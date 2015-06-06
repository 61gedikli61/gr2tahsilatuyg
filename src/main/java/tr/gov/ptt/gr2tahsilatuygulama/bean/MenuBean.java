
package tr.gov.ptt.gr2tahsilatuygulama.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Menu;

@ManagedBean
@SessionScoped
public class MenuBean 
{
    private MenuModel menumodel;
    @ManagedProperty(value="#{kisiBean}")
    private KisiBean kisibean;
    
    public MenuModel getMenumodel() {
        return menumodel;
    }
    
    public MenuBean()
    {
        menumodel=new DefaultMenuModel();
      
    }

    public KisiBean getKisibean()
    {
        return kisibean;
    }

    public void setKisibean(KisiBean kisibean)
    {
        this.kisibean = kisibean;
    }
   @PostConstruct
    public void initMenu()
            
    {
        DefaultSubMenu submenu=new DefaultSubMenu("Menü İşlemleri");
      
        
        DefaultMenuItem menuItem;
        
       List<Menu>menuliste =kisibean.getKisi().getTip().getMenuList();
       
      for(Menu menu:menuliste)
      {     menuItem=new DefaultMenuItem();
            menuItem.setValue(menu.getBaslik());
            menuItem.setCommand(menu.getLink());
            submenu.addElement(menuItem);
      }
             menumodel.addElement(submenu);
    }
}
