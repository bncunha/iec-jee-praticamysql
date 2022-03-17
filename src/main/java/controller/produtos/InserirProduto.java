package controller.produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;
import business.ProdutoService;
import exceptions.ProdutoException;
import model.Categoria;


/**
 * Servlet implementation class InserirCategoria
 */
@WebServlet(urlPatterns = "/produtos/inserir")
public class InserirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ProdutoService service;

	@EJB
	private CategoriaService categoriaService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String nome = request.getParameter("nome");
		Float valor = Float.parseFloat(request.getParameter("preco"));
		Integer idCategoria = Integer.parseInt(request.getParameter("categoria"));
		
		try {
			service.inserir(nome, valor, idCategoria);	
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (ProdutoException ex) {
			ex.printStackTrace();
			setCategorias(request);
			request.setAttribute("mensagemErro", ex.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/inserir.jsp");
			dispatcher.forward(request, response);
		
		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel inserir o produto!</h2>");
			out.print("<br/>");
			out.print("<a href = 'index.jsp'> Voltar </a>");
			out.print("</html>");
		}			
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			setCategorias(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/inserir.jsp");
			dispatcher.forward(request, response);
		} catch (Error ex) {
			throw new ServletException(ex);
		}
	}

	private void setCategorias(HttpServletRequest request) {
		List<Categoria> listaCategoria = categoriaService.listar();
		request.setAttribute("listaCategoria", listaCategoria);
	}
	
}
