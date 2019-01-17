package service;

import entity.Author;
import entity.Publisher;

public interface ContractService {

    boolean createContract(Author author, Publisher publisher);
}
