import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    int i = 0;
    Resume[] storage = new Resume[10];

    void clear() {
        Arrays.fill(storage, 0, i+1, null);
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
        return storage[Arrays.asList(storage).indexOf(uuid)];
    }

    void delete(String uuid) {

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] result = Arrays.copyOf(storage, i+1);
        return result;
    }

    int size() {
        return i+1;
    }
}