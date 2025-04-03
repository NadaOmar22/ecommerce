package com.practice.ecommerce.daoImpl;

import com.practice.ecommerce.dao.BranchDAO;
import com.practice.ecommerce.model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchDAOImpl implements BranchDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Branch> getAllBranches() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Branch", Branch.class).list();
    }

    @Override
    public Branch getBranchById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Branch.class, id);
    }

    @Override
    public void saveOrUpdateBranch(Branch branch) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(branch);
    }

    @Override
    public void deleteBranch(int id) {
        Session session = sessionFactory.getCurrentSession();
        Branch branch = session.get(Branch.class, id);
        if (branch != null) {
            session.delete(branch);
        }
    }
}


