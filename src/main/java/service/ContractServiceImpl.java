package service;

import dao.AuthorDAOImpl;
import entity.Author;
import entity.Publisher;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ContractServiceImpl implements ContractService{

    @Inject
    private AuthorDAOImpl authorDAO;

    @Inject
    private Logger logger;

    @Override
    public boolean createContract(Author author, Publisher publisher) {
        List<Publisher> contracts = author.getContracts();

        //smlouva jiz byla uzavrena
        if (contracts.contains(publisher))
            return false;

        contracts.add(publisher);
        authorDAO.update(author);
        logger.info("Contract of author " + author.getFirstname() + " " +
                author.getLastname() + " and publisher " + publisher.getName() +
                " was successfully signed");
        return true;
    }
}
