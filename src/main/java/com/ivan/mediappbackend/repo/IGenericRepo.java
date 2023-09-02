package com.ivan.mediappbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

// We create an interface for the Repo because what if we have to change from Jpa to another database interface
// we would have to make all the changes in the classes, with this interface the only change has to be done here
// @NoRepositoryBean, so it doesnt crash creating a bean for the repo because we are using generics
@NoRepositoryBean
public interface IGenericRepo<T,ID> extends JpaRepository<T,ID> {
}
