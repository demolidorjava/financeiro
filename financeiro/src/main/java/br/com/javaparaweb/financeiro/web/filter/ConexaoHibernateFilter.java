package br.com.javaparaweb.financeiro.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.javaparaweb.financeiro.util.HibernateUtil;

/**
 * Servlet Filter implementation class ConexaoHibernateFilter
 */
@WebFilter(description = "Filter que vai permitir a implementação do padrão OpenSessionInView", urlPatterns = {
		"*.jsf" })
public class ConexaoHibernateFilter implements Filter {
	private SessionFactory sf;

	/**
	 * Default constructor.
	 */
	public ConexaoHibernateFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Session currentSession = this.sf.getCurrentSession();
		Transaction transaction = null;

		try {
			transaction = currentSession.beginTransaction();
			chain.doFilter(request, response);
			transaction.commit();

			if (currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (Throwable ex) {
			try {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
