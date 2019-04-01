import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private int arraySize = 0;
    private Resume[] storage = new Resume[10000];

    void update(Resume resume) {
        int index = getIndex(resume.uuid);
        if (index == -1) {
            System.out.println("UPDATE ERROR: Резюме не найдено");
        } else {
            storage[index] = resume;
        }
    }

    void clear() {
        Arrays.fill(storage, 0, arraySize, null);
        arraySize = 0;
    }

    void save(Resume r) {
        if (getIndex(r.uuid) != -1) {
            System.out.println("SAVE ERROR: Резюме " + r.uuid + " уже существует");
        } else if (arraySize == storage.length) {
            System.out.println("SAVE ERROR: Массив переполнен");
        } else {
            storage[arraySize] = r;
            arraySize++;
        }
    }

    Resume get(String uuid) {
        if (getIndex(uuid) == -1) {
            System.out.println("GET ERROR: Резюме не найдено");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("DELETE ERROR: Резюме не найдено");
        } else {
            for (int j = index; j < arraySize; j++) {
                storage[j] = storage[j + 1];
            }
            storage[arraySize - 1] = null;
            arraySize--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        return Arrays.copyOf(storage, arraySize);
    }

    int size() {
        return arraySize;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].uuid.equals(uuid))
                return i;
        }
        return -1;
    }
}