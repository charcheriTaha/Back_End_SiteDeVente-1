package Site.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Site.Spring.Entities.AppUser;


// @RepositoryRestResource
public interface UserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
}