package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{
	
	private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}
	
	@Test
	public void TC001_naoDeveCriarUmProdutoSeAlgumCampoEstiverVazio() {
		produtoPage.buttonCriar.click();
		produtoPage.buttonCriar.click();

		produtoPage.executarAcaoDeAdicionarProduto("1","1","1","1","");
		
		String mensagemErro = produtoPage.obterConteudoElemento(produtoPage.mensagemErro);
		
		produtoPage.buttonSair.click();
		produtoPage.buttonSair.click();
				
		assertEquals(mensagemErro, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC002_criarUmProdutoQuandoOsDadosForemPreenchidosCorretamente() {
		produtoPage.buttonCriar.click();

		produtoPage.executarAcaoDeAdicionarProduto("teste","teste","teste","teste","10/10/2024");
				
		produtoPage.buttonSair.click();
		
		String codigo = produtoPage.obterConteudoElemento(produtoPage.codigo);
		assertEquals(codigo, "teste");
	}
	
	@Test
	public void TC003() {
		produtoPage.buttonCriar.click();
		
		produtoPage.buttonX.click();
		
		String display = produtoPage.modalAdicionarProduto.getCssValue("display");
		
		assertEquals(display, "none");	
	}

}
