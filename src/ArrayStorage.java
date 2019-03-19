import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private int count = 0;
    private Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, count + 1, null);
    }

    void save(Resume r) {
        for (Resume resume : storage) {
            if (storage[count] == null) {
                storage[count] = r;
                break;
            }
            count++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < count; i++)
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < 10000; i++)
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            } else {
                break;
            }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        return Arrays.copyOf(storage, count + 1);
    }

    int size() {
        return count + 1;
    }
}