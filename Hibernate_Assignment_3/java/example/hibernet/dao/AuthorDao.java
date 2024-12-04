package example.hibernet.dao;

import java.util.List;

import example.hibernet.enitities.Author;
import com.example.entities.Book;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDao {

	public void addAuthor(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(author); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Retrieve an Author by ID (with associated Books)
    public Author getAuthorById(int authorId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Author.class, authorId); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update an Author and their Books
    public void updateAuthor(Author updatedAuthor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(updatedAuthor); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Delete an Author and their associated Books
    public void deleteAuthor(int authorId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Author author = session.get(Author.class, authorId);
            if (author != null) {
                session.delete(author); 
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Retrieve all Authors with their associated Books
    public List<Author> getAllAuthors() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Author", Author.class).list(); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
