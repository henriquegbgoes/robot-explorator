/**
 * 
 */
package br.com.usjt.robot.util;

import org.primefaces.context.RequestContext;

/**
 * @author Henrique
 *
 */
public class SiteUtil {

	/**
	 * Executa JavaScript no cliente a partir do servidor
	 * @param function String com a função JavaScript
	 */
	public static void executaJavaScript(final String function){
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute(function);
	}
}
