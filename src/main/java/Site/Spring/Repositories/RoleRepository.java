package Site.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Site.Spring.Entities.AppRole;


//@RepositoryRestResource
public interface RoleRepository extends JpaRepository<AppRole,Long> {
    public AppRole findByRoleName(String roleName);
}