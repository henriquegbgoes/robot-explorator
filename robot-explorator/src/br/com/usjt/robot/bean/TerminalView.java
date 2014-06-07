/**
 * 
 */
package br.com.usjt.robot.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.usjt.robot.util.SiteUtil;

/**
 * @author Henrique
 *
 */
@ManagedBean(name="terminalView")
@SessionScoped
public class TerminalView {
     
	private String retorno;
	private String prompt;
	private boolean userOk;
	private boolean passwordOk;
	
	
	public TerminalView(){
		retorno = new String("");
		prompt = new String("_usuario>");
		userOk = false;
	}
	
    public String handleCommandLogin(String command, String[] params) {
    	
    		if(command.equals("cls")){
    			SiteUtil.executaJavaScript("PF('term').clear()");
    		}else if(command.equals("home")){
    			SiteUtil.executaJavaScript("remoteInicio();");
    		}else if(command.equals("henriquegb")){
    			prompt = new String("_senha>");
    			userOk = true;
    			SiteUtil.executaJavaScript("remoteUpdate();");
    		}else if(userOk && command.equals("senha123")){
    			prompt = new String("_usuario>");
    			userOk = false;
    			retorno = "OK!";
    			SiteUtil.executaJavaScript("setTimeOut(1000);remoteInicio();");
    		}else if(userOk && command.equals("reset")){
    			prompt = new String("_usuario>");
    			userOk = false;
    			SiteUtil.executaJavaScript("remoteUpdate();");
    		}else{
    			retorno = "o comando '" + command + "' não foi reconhecido"; 
    		}
    		
    		
    		return retorno;
    }
    
    public String handleCommand(String command, String[] params) {
    	return "legal!";
    }
    
    public String abrirPaginaInicial(){
    	return "pretty:home";
    }

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public boolean isUserOk() {
		return userOk;
	}

	public void setUserOk(boolean userOk) {
		this.userOk = userOk;
	}

	public boolean isPasswordOk() {
		return passwordOk;
	}

	public void setPasswordOk(boolean passwordOk) {
		this.passwordOk = passwordOk;
	}
 
}