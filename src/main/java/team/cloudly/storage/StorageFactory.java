package team.cloudly.storage;

public interface StorageFactory {

    Storage getStorage(StorageMethod storageMethod);

}
