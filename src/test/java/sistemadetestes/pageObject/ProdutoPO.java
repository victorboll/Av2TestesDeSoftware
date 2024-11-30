package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
	
	@FindBy(id = "btn-adicionar")
	public WebElement buttonCriar;

	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "data")
	public WebElement inputData;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;
	
	@FindBy(id = "btn-sair")
	public WebElement buttonSair;
	
	@FindBy(css = "div.modal-header>button")
	public WebElement buttonX;
	
	@FindBy(id = "mensagem")
	public WebElement mensagemErro;
	
	@FindBy(css = "tbody>tr>td")
	public WebElement codigo;
	
	@FindBy(id = "cadastro-produto")
	public WebElement modalAdicionarProduto;
	
	
	/**
	 * Construtor padrão para criação de uma nova instância da página de produtos
	 * @param driver Driver da página de produtos
	 * */
	
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}

	public String obterConteudoElemento(WebElement input) {
		return input.getText();
	}
	
	public void executarAcaoDeAdicionarProduto(String codigo, String nome, String quantidade, String valor, String data) {
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);
		buttonSalvar.click();
	}
	
}
