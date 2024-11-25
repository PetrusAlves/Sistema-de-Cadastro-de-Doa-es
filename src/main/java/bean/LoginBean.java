package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import entidade.Login;
import entidade.Usuario;
import exception.JSFException;
import util.Util;

@ManagedBean
@SessionScoped
public class LoginBean
{

   private Login login;
   private Usuario usuario;
   
   public LoginBean() 
   {
      this.login = new Login();
      this.usuario = new Usuario();
   }

   public String esqueciSenha()
   {
      this.login = new Login();
      return "recupera-senha";
   }

   public String logar()
   {
      if (validarLogar())
      {
         try
         {
            String email = getLogin().getUsuario().toUpperCase().trim();
            String senha = Util.gerarHashSenha(getLogin().getSenha().trim());
            if (UsuarioDAO.logar(email, senha))
            {
               this.usuario = salvarUsuarioLogado(email);
               HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
               session.setAttribute("usuario", login);
               return "/app/navegacao.xhtml?faces-redirect=true";
            }
            else
            {
               Util.addMensagemErro("Usuário e/ou senha inválidos.");
            }
         }
         catch (Exception e)
         {
            Util.addMensagemErro("Ocorreu um erro ao tentar fazer login. Por favor, tente novamente.");
         }
      }
      return null;
   }
   
   public Usuario salvarUsuarioLogado(String email)
   {
      try
      {
        return UsuarioDAO.pesquisarUsuarioPorEmail(email);
      }
      catch (JSFException e)
      {
         Util.addMensagemErro("Erro inesperado!");
         throw new JSFException(e.getMessage());
      }
   }

   public String logout()
   {
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
      return "login.xhtml";
   }

   private boolean validarLogar()
   {
      if (Util.isCampoNullOrVazio(getLogin().getUsuario()))
      {
         Util.addMensagemErro("E-mail obrigatório");
         return false;
      }

      if (!Util.validarEmail(getLogin().getUsuario().trim()))
      {
         Util.addMensagemErro("E-mail inválido");
         return false;
      }

      if (Util.isCampoNullOrVazio(getLogin().getSenha()))
      {
         Util.addMensagemErro("Senha obrigatória");
         return false;
      }

      return true;
   }

   public Login getLogin()
   {
      return login;
   }

   public void setLogin(Login login)
   {
      this.login = login;
   }

   public Usuario getUsuario()
   {
      return usuario;
   }

   public void setUsuario(Usuario usuario)
   {
      this.usuario = usuario;
   }
}
