package com.example.demo;

import java.util.List;
import org.springframework.data.domain.Page;

public interface ClientServices {
	List<Client> getAllClient();
    void save(Client client);
    Client getById(Long id);
    void deleteViaId(long id);
    
    Page<Client> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}