import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    int i = 0;
    Resume[] storage = new Resume[10];

    void clear() {
        Arrays.fill(storage, 0, i + 1, null);
    }

    void save(Resume r) {
        for (Resume s : storage) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
            i++;
        }
    }

    Resume get(String uuid) {
        for (int c = 0; c < storage.length; c++) {
            if (storage[c].uuid == uuid) {
                return storage[c];
            }
            else {
                return null;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int c = 0; c < storage.length; c++) {
            if (storage[c].uuid == uuid) {
                storage[c] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] result = Arrays.copyOf(storage, i + 1);
        return result;
    }

    int size() {
        return i + 1;
    }
}