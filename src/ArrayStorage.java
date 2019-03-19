import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private int size = 0;
    private Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        for (Resume resume : storage) {
            if (storage[size] == null) {
                storage[size] = r;
                break;
            }
        }
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++)
            if (storage[i].uuid.equals(uuid)) return storage[i];
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                for (int c = i; c < size; c++) {
                    storage[c] = storage[c + 1];
                }
                size--;
            } else {
                System.out.println("Объект для удаления не найден");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}