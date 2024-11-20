package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavegacaoBean
{

   private String currentPage = "login.xhtml";

   public String getCurrentPage()
   {
      return this.currentPage;
   }

   public void setCurrentPage(String currentPage)
   {
      this.currentPage = currentPage;
   }

}