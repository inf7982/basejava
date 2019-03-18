import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private int i = 0;
    private Resume[] storage = new Resume[10];

    void clear() {
        Arrays.fill(storage, 0, i + 1, null);
    }

    void save(Resume r) {
        for (Resume ignored : storage) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
            i++;
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage)
            if (resume.uuid.equals(uuid)) {
                return resume;
            } else {
                return null;
            }
        return null;
    }

    void delete(String uuid) {
        for (int c = 0; c < storage.length; c++)
            if (storage[c].uuid.equals(uuid)) {
                storage[c] = null;
                break;
            }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        return Arrays.copyOf(storage, i + 1);
    }

    int size() {
        return i + 1;
    }
}