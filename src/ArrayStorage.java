import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private int arraySize = 0;
    private Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, arraySize, null);
        arraySize = 0;
    }

    void save(Resume r) {
        for (Resume resume : storage) {
            if (storage[arraySize] == null) {
                storage[arraySize] = r;
                arraySize++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < arraySize; j++) {
                    storage[j] = storage[j + 1];
                }
                arraySize--;
            }
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
}