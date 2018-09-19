package i9SystemTray;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
public class LeitorDeXML {
	
	private static String tagAtual="";
	private static String siglaAtual="";
	private static String tagAtributos="";

	public String CNPJDESTINATARIO = "";
	public String MODELO = "";
	public String SERIE = "";
	public String NUMERONF = "";
	public String DATAHORAEMISSAO = "";
	public String DATAENTRADASAIDA = "";
	public String TIPONF = "";
	public String IDDESTINATARIO = "";
	public String TIPOEMISSAO = "";
	public String CNPJEMITENTE = "";
	public String CODIGOPRODUTO = "";
	public String CODIGODEBARRAS = "";
	public String NOMEPRODUTO = "";
	public String NCM = "";
	public String CODIGOFISCAL = "";
	public String UNIDADECOMERCIAL = "";
	public String QUANTIDADECOMERCIAL = "";
	public String VALORUNITARIO = "";
	public String VALORTOTALPROD = "";
	public String CODIGODEBARRASTRIB = "";
	public String ORIGEM = "";
	
	//public String
	
	public String Retorno = "";
	public String lerXML(File arquivo){
		   
	    try {
	 
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
	 
		DefaultHandler handler = new DefaultHandler() {
	 
		boolean controleCNPJ = false;
		boolean controleDestCNPJ = false;
		boolean controleIde = false;
		boolean controleModelo = false;
		boolean controleSerie = false;
		boolean controleNumeroNF = false;
		boolean controleDataHoraEmissao = false;
		boolean controleDataHoraEntradaSaida = false;
		boolean controleTipoNF = false;
		boolean controleIdDestinatario = false;
		boolean controleTipoEmissao = false;
		boolean controleDetnItem = false;
		boolean controleProd = false;
		boolean controleCodigoProduto = false;
		boolean controleCodigoDeBarras = false;
		boolean controleNomeProduto = false;
		boolean controleNCM = false;
		boolean controleCodigoFiscal = false;
		boolean controleUnidadeComercial = false;
		boolean controleQuantidadeComercial = false;
		boolean controleValorUnitario = false;
		boolean controleValorTotalProd = false;
		boolean controleCodigoDeBarrasTrib = false;
		boolean controleImposto = false;
		boolean controleICMS = false;
		boolean controleICSM00 = false;
		boolean controleOrigem = false;
		
		
		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
	 
			tagAtual = qName;
			
			if (attributes.getValue("nItem")!=null) {
				tagAtributos = attributes.getValue("nItem");
				
			}
			
			//System.out.println(qName);
			if (qName.compareToIgnoreCase("dest") == 0) { 
				controleDestCNPJ = true;
			}
			if (qName.compareToIgnoreCase("ide") == 0) { 
				controleIde = true;
				controleModelo = true;
				controleSerie = true;
				controleNumeroNF = true;
				controleDataHoraEmissao = true;
				controleDataHoraEntradaSaida = true;
				controleTipoNF = true;
				controleIdDestinatario = true;
				controleTipoEmissao = true;
			}
			if (qName.compareToIgnoreCase("emit") == 0) { 
				controleCNPJ = true;
			}
			if (qName.compareToIgnoreCase("det") == 0) { 
				controleDetnItem = true;
				controleProd = true;
				controleCodigoProduto = true;
				controleCodigoDeBarras = true;
				controleNomeProduto = true;
				controleNCM = true;
				controleCodigoFiscal = true;
				controleUnidadeComercial = true;
				controleQuantidadeComercial = true;
				controleValorUnitario = true;
				controleValorTotalProd = true;
				controleCodigoDeBarrasTrib = true;
				
			}
			if (qName.compareToIgnoreCase("imposto") == 0) { 
				controleImposto = true;
				controleICMS = true;
				controleICSM00 = true;
				controleOrigem = true;
			}
		}
	 
		public void endElement(String uri, String localName,
			String qName) throws SAXException {
	 
			////System.out.println("End Element :" + qName);
	 
		}
		public void endDocument() {
			//System.out.println("TESTE: "+CNPJEMITENTE);
		Retorno =  gerarLayoutI9(CNPJEMITENTE,CNPJDESTINATARIO, MODELO, NUMERONF, SERIE, DATAHORAEMISSAO, DATAENTRADASAIDA, TIPONF, IDDESTINATARIO, TIPOEMISSAO, CODIGOPRODUTO, CODIGODEBARRAS, NOMEPRODUTO, NCM, CODIGOFISCAL, UNIDADECOMERCIAL, QUANTIDADECOMERCIAL, VALORUNITARIO, VALORTOTALPROD, CODIGODEBARRASTRIB, ORIGEM);	
		}

		public void characters(char ch[], int start, int length) throws SAXException {

			String texto = new String(ch, start, length); 
			
			if (controleCNPJ){
				if (tagAtual.compareToIgnoreCase("CNPJ") == 0) { 
					//System.out.println("CNPJ EMITENTE: "+texto); 
					CNPJEMITENTE = texto;
					controleCNPJ = false;
				}
				
			}
			if (controleDestCNPJ){
				if ((tagAtual.compareToIgnoreCase("CNPJ") == 0) || (tagAtual.compareToIgnoreCase("CPF") == 0)) { 
					CNPJDESTINATARIO = texto;
					controleDestCNPJ = false;
				}
			}
			if (controleIde){
				if(controleModelo || controleNumeroNF || controleSerie || controleDataHoraEmissao || controleDataHoraEntradaSaida || controleTipoNF || controleIdDestinatario || controleTipoEmissao || controleUnidadeComercial) {
					if ((tagAtual.compareToIgnoreCase("mod") == 0)) { 						
						MODELO = texto;
						controleModelo = false;
					}
					if ((tagAtual.compareToIgnoreCase("nNF") == 0)) {  
						NUMERONF = texto;
						controleNumeroNF = false;
					}
					if ((tagAtual.compareToIgnoreCase("serie") == 0)) {  
						SERIE = texto;
						controleSerie = false;
					}
					if ((tagAtual.compareToIgnoreCase("dhEmi") == 0)) {  
						DATAHORAEMISSAO = texto;
						controleDataHoraEmissao = false;
					}
					if ((tagAtual.compareToIgnoreCase("dhSaiEnt") == 0)) {  
						DATAENTRADASAIDA = texto;
						controleDataHoraEntradaSaida = false;
					}
					if ((tagAtual.compareToIgnoreCase("tpNF") == 0)) {  
						TIPONF = texto;
						controleTipoNF = false;
					}
					if ((tagAtual.compareToIgnoreCase("idDest") == 0)) {  
						IDDESTINATARIO = texto;
						controleIdDestinatario = false;
					}
					if ((tagAtual.compareToIgnoreCase("tpEmis") == 0)) {  
						TIPOEMISSAO = texto;
						controleTipoEmissao = false;
					}
				}
			if (controleDetnItem){
				if (controleProd) {
					if(controleCodigoProduto || controleCodigoDeBarras || controleNomeProduto || controleNCM || controleCodigoFiscal || controleUnidadeComercial || controleQuantidadeComercial || controleValorUnitario || controleValorTotalProd || controleCodigoDeBarrasTrib) {
						if ((tagAtual.compareToIgnoreCase("cProd") == 0)) { 
							CODIGOPRODUTO = texto;
							controleCodigoProduto = false;
						}
						if ((tagAtual.compareToIgnoreCase("cEAN") == 0)) { 
							CODIGODEBARRAS = texto;
							controleCodigoDeBarras = false;
						}
						if ((tagAtual.compareToIgnoreCase("xProd") == 0)) {  
							NOMEPRODUTO = texto;
							controleNomeProduto = false;
						}
						if ((tagAtual.compareToIgnoreCase("NCM") == 0)) {  
							NCM = texto;
							controleNCM = false;
						}
						if ((tagAtual.compareToIgnoreCase("CFOP") == 0)) {  
							CODIGOFISCAL = texto;
							controleCodigoFiscal = false;
						}
						if ((tagAtual.compareToIgnoreCase("uCom") == 0)) {  
							UNIDADECOMERCIAL = texto;
							controleUnidadeComercial = false;
						}
						if ((tagAtual.compareToIgnoreCase("QCom") == 0)) {  
							QUANTIDADECOMERCIAL = texto;
							controleQuantidadeComercial = false;
						}
						if ((tagAtual.compareToIgnoreCase("vUnCom") == 0)) {  
							VALORUNITARIO = texto;
							controleValorUnitario = false;
						}
						if ((tagAtual.compareToIgnoreCase("vProd") == 0)) {  
							VALORTOTALPROD = texto;
							controleValorTotalProd = false;
						}
						if ((tagAtual.compareToIgnoreCase("cEANTrib") == 0)) {  
							CODIGODEBARRASTRIB = texto;
							controleCodigoDeBarrasTrib = false;
						}
					}
				}
			}if(controleImposto) {
				if(controleICMS) {
					if(controleICSM00) {
						if(controleOrigem) {
							if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
								ORIGEM = texto;
								controleOrigem = false;
							}
						}
					}
				}
			}
		}
	}
 };
	       saxParser.parse(arquivo, handler);
	 
	     } catch (Exception e) {
	       e.printStackTrace();
	     }
		return Retorno;
	 
	   }
	   
	private String gerarLayoutI9(String cNPJEMITENTE, String CNPJDESTINATARIO, String MODELO, String NUMERONF, String SERIE, String DATAHORAEMISSAO, String DATAENTRADASAIDA, String TIPONF, String IDDESTINATARIO, String TIPOEMISSAO, String CODIGOPRODUTO, String CODIGODEBARRAS, String NOMEPRODUTO, String NCM, String CODIGOFISCAL, String UNIDADECOMERCIAL, String QUANTIDADECOMERCIAL, String VALORUNITARIO, String VALORTOTALPROD, String CODIGODEBARRASTRIB, String ORIGEM) {
	   
	   //System.out.println("TESTE: "+cNPJEMITENTE);
	   //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	   //String dataEmissaoCon[] = DATAHORAEMISSAO.split("T");
	   
	   //String dataEmissaoFormat = dataEmissaoCon[0].substring(8,10)+"/"+dataEmissaoCon[0].substring(5,7)+"/"+dataEmissaoCon[0].substring(0,4);
	   //System.out.println(sdf.format(new Date())); 
	   //String isentas = "0,00";
	  // System.out.println("VL ICMS: "+vLICMS);
	   
		System.out.println(cNPJEMITENTE);
		System.out.println(CNPJDESTINATARIO);
		System.out.println(MODELO);
		System.out.println(SERIE);
		System.out.println(NUMERONF);
		System.out.println(DATAHORAEMISSAO);
		System.out.println(DATAENTRADASAIDA);
		System.out.println(TIPONF);
		System.out.println(IDDESTINATARIO);
		System.out.println(TIPOEMISSAO);
		System.out.println(CODIGOPRODUTO);
		System.out.println(CODIGODEBARRAS);
		System.out.println(NOMEPRODUTO);
		System.out.println(NCM);
		System.out.println(CODIGOFISCAL);
		System.out.println(UNIDADECOMERCIAL);
		System.out.println(QUANTIDADECOMERCIAL);
		System.out.println(VALORUNITARIO);
		System.out.println(VALORTOTALPROD);
		System.out.println(CODIGODEBARRASTRIB);
		System.out.println(ORIGEM);
		
		return "";
	}

	public static void main(String[] args) {
		File arquivo = new File("C:\\i9\\nota.xml");
		LeitorDeXML leitor = new LeitorDeXML();
		leitor.lerXML(arquivo);
	}	
}
