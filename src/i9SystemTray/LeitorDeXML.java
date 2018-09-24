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
	
	private static String tagAtual = "";
	private static String siglaAtual = "";
	private static String tagAtributos = "";
	private static String chaveAtributos = "";

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
	public String CST = "";
	public String MODBC = "";
	public String VBC = "";
	public String PICMS = "";
	public String VICMS = "";
	public String MODBCST = "";
	public String VBCST = "";
	public String PICMSST = "";
	public String VICMSST = "";
	public String VICMSOP = "";
	public String PBCOP = "";
	public String UFST = "";
	public String VBCSTRET = "";
	public String VICMSSTRET = "";
	public String CSOSN = "";
	public String PCREDSN = "";
	public String VCREDICMSSN = "";
	public String PIPI = "";
	public String QUNID = "";
	public String VUNID = "";
	public String VIPI = "";
	public String PPIS = "";
	public String VPIS = "";
	public String QBCPROD = "";
	public String VALIQPROD = "";
	public String PCOFINS = "";
	public String VCOFINS = "";

	
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
		boolean controleICMS00 = false;
		boolean controleOrigem = false;
		boolean controleCST = false;
		boolean controleMODBC = false;
		boolean controleVBC = false;
		boolean controlePICMS = false;
		boolean controleVICMS = false;
		boolean controleICMS10 = false;
		boolean controleMODBCST = false;
		boolean controleVBCST = false;
		boolean controlePICMSST = false;
		boolean controleVICMSST = false;
		boolean controleICMS20 = false;
		boolean controleICMS30 = false;
		boolean controleICMS40 = false;
		boolean controleICMS51 = false;
		boolean controleVICMSOP = false;
		boolean controleICMS60 = false;
		boolean controleICMS70 = false;
		boolean controleICMS90 = false;
		boolean controleICMSPart = false;
		boolean controlePBCOP = false;
		boolean controleUFST = false;
		boolean controleICMSST = false;
		boolean controleVBCSTRET = false;
		boolean controleVICMSSTRET = false;
		boolean controleICMSSN101 = false;
		boolean controleCSOSN = false;
		boolean controlePCREDSN = false;
		boolean controleVCREDICMSSN = false;
		boolean controleICMSSN102 = false;
		boolean controleICMSSN201 = false;
		boolean controleICMSSN202 = false;
		boolean controleICMSSN500 = false;
		boolean controleICMSSN900 = false;
		boolean controleIPI = false;
		boolean controleIPITrib = false;
		boolean controlePIS = false;
		boolean controlePISST = false;
		boolean controleCOFINS = false;
		boolean controleCOFINSST = false;
		boolean controlePIPI = false;
		boolean controleQUNID = false;
		boolean controleVUNID = false;
		boolean controleVIPI = false;
		boolean controleIPINT = false;
		boolean controlePISALIQ = false;
		boolean controlePPIS = false;
		boolean controleVPIS = false;
		boolean controlePISQTDE = false;
		boolean controleQBCPROD = false;
		boolean controleVALIQPROD = false;
		boolean controlePISNT = false;
		boolean controlePISOUTR = false;
		boolean controleCOFINSALIQ = false;
		boolean controlePCOFINS = false;
		boolean controleVCOFINS = false;
		boolean controleCOFINSQTDE = false;
		boolean controleCOFINSNT = false;
		boolean controleCOFINSOUTR = false;
		
		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
	 
			tagAtual = qName;
			
			if (attributes.getValue("nItem")!=null) {
				tagAtributos = attributes.getValue("nItem");
				System.out.println(tagAtributos);
				
			}
			
			if (attributes.getValue("Id")!=null) {
				chaveAtributos = attributes.getValue("Id");
				chaveAtributos = chaveAtributos.substring(3, chaveAtributos.length());
				System.out.println(chaveAtributos);
			}
			
			
			//System.out.println(qName);
			if (qName.compareToIgnoreCase("dest") == 0) { 
				controleDestCNPJ = true;
			}
			if (qName.compareToIgnoreCase("IPI") == 0) { 
				controleIPI = true;
			}
			
			if (qName.compareToIgnoreCase("infNFe") == 0) { 
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
				/*controleImposto = true;
				controleICMS = true;
				controleICMS00 = true;
				controleOrigem = true;
				controleCST = true;
				controleMODBC = true;
				controleVBC = true;
				controlePICMS = true;
				controleVICMS = true;
				controleICMS10 = true;
				controleMODBCST = true;
				controleVBCST = true;
				controlePICMSST = true;
				controleVICMSST = true;
				controleICMS20 = true;
				controleICMS30 = true;
				controleICMS40 = true;
				controleICMS51 = true;
				controleVICMSOP = true;
				controleICMS60 = true;
				controleICMS70 = true;
				controleICMS90 = true;
				controleICMSPart = true;
				controlePBCOP = true;
				controleUFST = true;
				controleICMSST = true;
				controleVBCSTRET = true;
				controleVICMSSTRET = true;
				controleICMSSN101 = true;
				controleCSOSN = true;
				controlePCREDSN = true;
				controleVCREDICMSSN = true;
				controleICMSSN201 = true;
				controleICMSSN202 = true;
				controleICMSSN500 = true;
				controleICMSSN900 = true;*/
			}
			if (qName.compareToIgnoreCase("imposto") == 0) { 
				controleImposto = true;
				controleICMS = true;
				controleICMS00 = true;
				controleOrigem = true;
				controleCST = true;
				controleMODBC = true;
				controleVBC = true;
				controlePICMS = true;
				controleVICMS = true;
				controleICMS10 = true;
				controleMODBCST = true;
				controleVBCST = true;
				controlePICMSST = true;
				controleVICMSST = true;
				controleICMS20 = true;
				controleICMS30 = true;
				controleICMS40 = true;
				controleICMS51 = true;
				controleVICMSOP = true;
				controleICMS60 = true;
				controleICMS70 = true;
				controleICMS90 = true;
				controleICMSPart = true;
				controlePBCOP = true;
				controleUFST = true;
				controleICMSST = true;
				controleVBCSTRET = true;
				controleVICMSSTRET = true;
				controleICMSSN101 = true;
				controleCSOSN = true;
				controlePCREDSN = true;
				controleVCREDICMSSN = true;
				controleICMSSN201 = true;
				controleICMSSN202 = true;
				controleICMSSN500 = true;
				controleICMSSN900 = true;
				controleIPITrib = true;
				controlePIS = true;
				controlePISST = true;
				controleCOFINS = true;
				controleCOFINSST = true;
				controlePIPI = true;
				controleQUNID = true;
				controleVUNID = true;
				controleVIPI = true;
				controlePISALIQ = true;
				controlePPIS = true;
				controleVPIS = true;
				controleQBCPROD = true;
				controleVALIQPROD = true;
				controlePISNT = true;
				controlePISOUTR = true;
				controleCOFINSALIQ = true;
				controlePCOFINS = true;
				controleCOFINSQTDE = true;
				controleCOFINSNT = true;
				controleCOFINSOUTR = true;
			}
		}
	 
		public void endElement(String uri, String localName,
			String qName) throws SAXException {
		}
		
		public void endDocument() {
		Retorno =  gerarLayoutI9(CNPJEMITENTE,CNPJDESTINATARIO, MODELO, NUMERONF, SERIE, DATAHORAEMISSAO, 
								 DATAENTRADASAIDA, TIPONF, IDDESTINATARIO, TIPOEMISSAO, CODIGOPRODUTO, 
								 CODIGODEBARRAS, NOMEPRODUTO, NCM, CODIGOFISCAL, UNIDADECOMERCIAL, QUANTIDADECOMERCIAL, 
								 VALORUNITARIO, VALORTOTALPROD, CODIGODEBARRASTRIB, ORIGEM, CST, MODBC, VBC, PICMS, 
								 VICMS, MODBCST, VBCST, PICMSST, VICMSST, VICMSOP, PBCOP, UFST, VBCSTRET, VICMSSTRET, CSOSN, 
								 PCREDSN, VCREDICMSSN, PIPI, QUNID, VUNID, VIPI, PPIS, VPIS, QBCPROD, VALIQPROD, PCOFINS, VCOFINS);	
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
						}
						if (controleIPI) {
							controleICMS = false;
							controleICMS00 = false;
							controleOrigem = false;
							controleCST = false;
							controleMODBC = false;
							controleVBC = false;
							controlePICMS = false;
							controleVICMS = false;
							controleOrigem = false;
							controleCST = false;
							controleMODBC = false;
							controleVBC = false;
							controlePICMS = false;
							controleVICMS = false;
							controleICMS10 = false;
							controleMODBCST = false;
							controleVBCST = false;
							controlePICMSST = false;
							controleVICMSST = false;
							controleICMS20 = false;
							controleICMS30 = false;
							controleICMS40 = false;
							controleICMS51 = false;
							controleVICMSOP = false;
							controleICMS60 = false;
							controleICMS70 = false;
							controleICMS90 = false;
							controleICMSPart = false;
							controlePBCOP = false;
							controleUFST = false;
							controleICMSST = false;
							controleVBCSTRET = false;
							controleVICMSSTRET = false;
							controleICMSSN101 = false;
							controleCSOSN = false;
							controlePCREDSN = false;
							controleVCREDICMSSN = false;
							controleICMSSN102 = false;
							controleICMSSN201 = false;
							controleICMSSN202 = false;
							controleICMSSN500 = false;
							controleICMSSN900 = false;
						}
						if(controleImposto) {
							
							if(controleICMS) {
								if(controleICMS00) {
									if(controleOrigem || controleCST || controleMODBC || controleVBC || controlePICMS || controleVICMS) {
										if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
											ORIGEM = texto;
											controleOrigem = false;
										}
										if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
											CST = texto;
											controleCST = false;
										}
										if ((tagAtual.compareToIgnoreCase("modBC") == 0)) {  
											MODBC = texto;
											controleMODBC = false;
										}
										if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
											VBC = texto;
											controleVBC = false;
										}
										if ((tagAtual.compareToIgnoreCase("pICMS") == 0)) {  
											PICMS = texto;
											controlePICMS = false;
										}
										if ((tagAtual.compareToIgnoreCase("vICMS") == 0)) {  
											VICMS = texto;
											controleVICMS = false;
										}
									}
								}

							if(controleICMS10) {
								if(controleOrigem || controleCST || controleMODBC || controleVBC || controlePICMS || controleVICMS || controleMODBCST || controleVBCST || controlePICMSST || controleVICMSST) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("modBC") == 0)) {  
										MODBC = texto;
										controleMODBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
										VBC = texto;
										controleVBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMS") == 0)) {  
										PICMS = texto;
										controlePICMS = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMS") == 0)) {  
										VICMS = texto;
										controleVICMS = false;
									}
									if ((tagAtual.compareToIgnoreCase("modBCST") == 0)) {  
										MODBCST = texto;
										controleMODBCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBCST") == 0)) {  
										VBCST = texto;
										controleVBCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMSST") == 0)) {  
										PICMSST = texto;
										controlePICMSST = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMSST") == 0)) {  
										VICMSST = texto;
										controleVICMSST = false;
									}
								}
							}
							if(controleICMS20) {
								if(controleOrigem || controleCST || controleMODBC || controlePICMS || controleVICMS) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("modBC") == 0)) {  
										MODBC = texto;
										controleMODBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMS") == 0)) {  
										PICMS = texto;
										controlePICMS = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMS") == 0)) {  
										VICMS = texto;
										controleVICMS = false;
									}
								}
							}
							if(controleICMS30) {
								if(controleOrigem || controleCST || controleMODBCST || controleVBCST || controlePICMSST || controleVICMSST) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("modBCST") == 0)) {  
										MODBCST = texto;
										controleMODBCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBCST") == 0)) {  
										VBCST = texto;
										controleVBCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMSST") == 0)) {  
										PICMSST = texto;
										controlePICMSST = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMSST") == 0)) {  
										VICMSST = texto;
										controleVICMSST = false;
									}
								}
							}
							if(controleICMS40) {
								if(controleOrigem || controleCST) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
								}
							}
							if(controleICMS51) {
								if(controleOrigem || controleCST || controleMODBC || controleVBC || controlePICMS || controleVICMSOP || controleVICMS) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									if ((tagAtual.compareToIgnoreCase("modBC") == 0)) {  
										MODBC = texto;
										controleMODBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
										VBC = texto;
										controleVBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMS") == 0)) {  
										PICMS = texto;
										controlePICMS = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMSOp") == 0)) {  
										VICMSOP = texto;
										controleVICMSOP = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMS") == 0)) {  
										VICMS = texto;
										controleVICMS = false;
									}
								}
							}
							if(controleICMS60) {
								if(controleOrigem || controleCST) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
								}
							}
							if(controleICMS70) {
								if(controleOrigem || controleCST || controleMODBC || controleVBC || controlePICMS || controleVICMS || controleVBCST || controlePICMSST || controleVICMSST || controleMODBCST) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("modBC") == 0)) {  
										MODBC = texto;
										controleMODBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
										VBC = texto;
										controleVBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMS") == 0)) {  
										PICMS = texto;
										controlePICMS = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMS") == 0)) {  
										VICMS = texto;
										controleVICMS = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBCST") == 0)) {  
										VBCST = texto;
										controleVBCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMSST") == 0)) {  
										PICMSST = texto;
										controlePICMSST = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMSST") == 0)) {  
										VICMSST = texto;
										controleVICMSST = false;
									}
									if ((tagAtual.compareToIgnoreCase("modBCST") == 0)) {  
										MODBCST = texto;
										controleMODBCST = false;
									}
								}
							}
							if(controleICMS90) {
								if(controleOrigem || controleCST) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
								}
							}
							if(controleICMSPart) {
								if(controleOrigem || controleCST || controleMODBC || controleVBC || controlePICMS || controleVICMS || controleMODBCST || controleVBCST || controlePICMSST || controleVICMSST || controlePBCOP || controleUFST) {
									if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
										ORIGEM = texto;
										controleOrigem = false;
									}
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									if ((tagAtual.compareToIgnoreCase("modBC") == 0)) {  
										MODBC = texto;
										controleMODBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
										VBC = texto;
										controleVBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMS") == 0)) {  
										PICMS = texto;
										controlePICMS = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMS") == 0)) {  
										VICMS = texto;
										controleVICMS = false;
									}
									if ((tagAtual.compareToIgnoreCase("modBCST") == 0)) {  
										MODBCST = texto;
										controleMODBCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBCST") == 0)) {  
										VBCST = texto;
										controleVBCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("pICMSST") == 0)) {  
										PICMSST = texto;
										controlePICMSST = false;
									}
									if ((tagAtual.compareToIgnoreCase("vICMSST") == 0)) {  
										VICMSST = texto;
										controleVICMSST = false;
									}
									if ((tagAtual.compareToIgnoreCase("pBCOp") == 0)) {  
										PBCOP = texto;
										controlePBCOP = false;
									}
									if ((tagAtual.compareToIgnoreCase("UFST") == 0)) {  
										UFST = texto;
										controleUFST = false;
									}
								}
							}				
						}
						if(controleICMSST) {
							if(controleOrigem || controleCST || controleVBCSTRET || controleVICMSSTRET) {
								if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
									ORIGEM = texto;
									controleOrigem = false;
								}
								if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
									CST = texto;
									controleCST = false;
								}
								if ((tagAtual.compareToIgnoreCase("vBCSTRet") == 0)) {  
									VBCSTRET = texto;
									controleVBCSTRET = false;
								}
								if ((tagAtual.compareToIgnoreCase("vICMSSTRet") == 0)) {  
									VICMSSTRET = texto;
									controleVICMSSTRET = false;
								}
							}
						}
						if(controleICMSSN101) {
							if(controleOrigem || controleCSOSN || controlePCREDSN || controleVCREDICMSSN) {
								if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
									ORIGEM = texto;
									controleOrigem = false;
								}
								if ((tagAtual.compareToIgnoreCase("CSOSN") == 0)) {  
									CSOSN = texto;
									controleCSOSN = false;
								}
								if ((tagAtual.compareToIgnoreCase("pCredSN") == 0)) {  
									PCREDSN = texto;
									controlePCREDSN = false;
								}
								if ((tagAtual.compareToIgnoreCase("vCredICMSSN") == 0)) {  
									VCREDICMSSN = texto;
									controleVCREDICMSSN = false;
								}
							}
						}
						if(controleICMSSN102) {
							if(controleOrigem || controleCSOSN) {
								if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
									ORIGEM = texto;
									controleOrigem = false;
								}
								if ((tagAtual.compareToIgnoreCase("CSOSN") == 0)) {  
									CSOSN = texto;
									controleCSOSN = false;
								}
							}
						}
						if(controleICMSSN201) {
							if(controleOrigem || controleCSOSN || controleMODBCST || controleVBCST || controlePICMSST || controleVICMSST) {
								if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
									ORIGEM = texto;
									controleOrigem = false;
								}
								if ((tagAtual.compareToIgnoreCase("CSOSN") == 0)) {  
									CSOSN = texto;
									controleCSOSN = false;
								}
								if ((tagAtual.compareToIgnoreCase("modBCST") == 0)) {  
									MODBCST = texto;
									controleMODBCST = false;
								}
								if ((tagAtual.compareToIgnoreCase("vBCST") == 0)) {  
									VBCST = texto;
									controleVBCST = false;
								}
								if ((tagAtual.compareToIgnoreCase("pICMSST") == 0)) {  
									PICMSST = texto;
									controlePICMSST = false;
								}
								if ((tagAtual.compareToIgnoreCase("vICMSST") == 0)) {  
									VICMSST = texto;
									controleVICMSST = false;
								}
							}
						}
						if(controleICMSSN202) {
							if(controleOrigem || controleCSOSN || controleMODBCST || controleVBCST || controlePICMSST || controleVICMSST) {
								if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
									ORIGEM = texto;
									controleOrigem = false;
								}
								if ((tagAtual.compareToIgnoreCase("CSOSN") == 0)) {  
									CSOSN = texto;
									controleCSOSN = false;
								}
								if ((tagAtual.compareToIgnoreCase("modBCST") == 0)) {  
									MODBCST = texto;
									controleMODBCST = false;
								}
								if ((tagAtual.compareToIgnoreCase("vBCST") == 0)) {  
									VBCST = texto;
									controleVBCST = false;
								}
								if ((tagAtual.compareToIgnoreCase("pICMSST") == 0)) {  
									PICMSST = texto;
									controlePICMSST = false;
								}
								if ((tagAtual.compareToIgnoreCase("vICMSST") == 0)) {  
									VICMSST = texto;
									controleVICMSST = false;
								}
							}
						}
						if(controleICMSSN500) {
							if(controleOrigem || controleCSOSN) {
								if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
									ORIGEM = texto;
									controleOrigem = false;
								}
								if ((tagAtual.compareToIgnoreCase("CSOSN") == 0)) {  
									CSOSN = texto;
									controleCSOSN = false;
								}
							}
						}
						if(controleICMSSN900) {
							if(controleOrigem || controleCSOSN) {
								if ((tagAtual.compareToIgnoreCase("orig") == 0)) {  
									ORIGEM = texto;
									controleOrigem = false;
								}
								if ((tagAtual.compareToIgnoreCase("CSOSN") == 0)) {  
									CSOSN = texto;
									controleCSOSN = false;
								}
							}
						}
					}
				}
							if(controleIPITrib) {
								if(controleCST || controleVBC || controlePIPI || controleQUNID || controleVUNID || controleVIPI) {
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
									if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
										VBC = texto;
										controleVBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("pIPI") == 0)) {  
										PIPI = texto;
										controlePIPI = false;
									}
									if ((tagAtual.compareToIgnoreCase("qUnid") == 0)) {  
										QUNID = texto;
										controleQUNID = false;
									}
									if ((tagAtual.compareToIgnoreCase("vUnid") == 0)) {  
										VUNID = texto;
										controleVUNID = false;
									}
									if ((tagAtual.compareToIgnoreCase("vIPI") == 0)) {  
										VIPI = texto;
										controleVIPI = false;
									}
								}
							}
							if(controleIPINT){
								if(controleCST){
									if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
										CST = texto;
										controleCST = false;
									}
								}
							}
							if(controlePIS){
								if(controlePISALIQ) {
									if(controleCST || controleVBC || controlePPIS || controleVPIS){
										if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
											CST = texto;
											controleCST = false;
										}
										if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
											VBC = texto;
											controleVBC = false;
										}
										if ((tagAtual.compareToIgnoreCase("pPIS") == 0)) {  
											PPIS = texto;
											controlePPIS = false;
										}
										if ((tagAtual.compareToIgnoreCase("vPIS") == 0)) {  
											VPIS = texto;
											controleVPIS = false;
										}
									}
								}
								if(controlePISQTDE) {
									if(controleCST || controleQBCPROD || controleVALIQPROD || controleVPIS){
										if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
											CST = texto;
											controleCST = false;
										}
										if ((tagAtual.compareToIgnoreCase("qBCProd") == 0)) {  
											QBCPROD = texto;
											controleQBCPROD = false;
										}
										if ((tagAtual.compareToIgnoreCase("vAliqProd") == 0)) {  
											VALIQPROD = texto;
											controleVALIQPROD = false;
										}
										if ((tagAtual.compareToIgnoreCase("vPIS") == 0)) {  
											VPIS = texto;
											controleVPIS = false;
										}
									}
								}
								if(controlePISNT){
									if(controleCST){
										if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
											CST = texto;
											controleCST = false;
										}
									}
								}
								if(controlePISOUTR){
									if(controleCST || controleVBC || controlePPIS || controleQBCPROD || controleVALIQPROD || controleVPIS){
										if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
											CST = texto;
											controleCST = false;
										}
										if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
											VBC = texto;
											controleVBC = false;
										}
										if ((tagAtual.compareToIgnoreCase("pPIS") == 0)) {  
											PPIS = texto;
											controlePPIS = false;
										}
										if ((tagAtual.compareToIgnoreCase("qBCProd") == 0)) {  
											QBCPROD = texto;
											controleQBCPROD = false;
										}
										if ((tagAtual.compareToIgnoreCase("vAliqProd") == 0)) {  
											VALIQPROD = texto;
											controleVALIQPROD = false;
										}
										if ((tagAtual.compareToIgnoreCase("vAliqProd") == 0)) {  
											VPIS = texto;
											controleVPIS = false;
										}
									}
								}
							}
							if(controlePISST) {
								if(controleVBC || controlePPIS || controleQBCPROD || controleVALIQPROD || controleVPIS) {
									if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
										VBC = texto;
										controleVBC = false;
									}
									if ((tagAtual.compareToIgnoreCase("pPIS") == 0)) {  
										PPIS = texto;
										controlePPIS = false;
									}
									if ((tagAtual.compareToIgnoreCase("qBCProd") == 0)) {  
										QBCPROD = texto;
										controleQBCPROD = false;
									}
									if ((tagAtual.compareToIgnoreCase("vAliqProd") == 0)) {  
										VALIQPROD = texto;
										controleVALIQPROD = false;
									}
									if ((tagAtual.compareToIgnoreCase("vAliqProd") == 0)) {  
										VPIS = texto;
										controleVPIS = false;
									}
								}
							}
							if(controleCOFINS){
								if(controleCOFINSALIQ) {
									if(controleCST || controleVBC || controlePCOFINS || controleVCOFINS){
										if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
											CST = texto;
											controleCST = false;
										}
										if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
											VBC = texto;
											controleVBC = false;
										}
										if ((tagAtual.compareToIgnoreCase("pCOFINS") == 0)) {  
											PCOFINS = texto;
											controlePCOFINS = false;
										}
										if ((tagAtual.compareToIgnoreCase("vCOFINS") == 0)) {  
											VCOFINS = texto;
											controleVCOFINS = false;
										}
									}
								}
								if(controleCOFINS){
									if(controleCOFINSQTDE) {
										if(controleCST || controleQBCPROD || controleVALIQPROD || controleVCOFINS){
											if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
												CST = texto;
												controleCST = false;
											}
											if ((tagAtual.compareToIgnoreCase("qBCProd") == 0)) {  
												QBCPROD = texto;
												controleQBCPROD = false;
											}
											if ((tagAtual.compareToIgnoreCase("vAliqProd") == 0)) {  
												VALIQPROD = texto;
												controleVALIQPROD = false;
											}
											if ((tagAtual.compareToIgnoreCase("vCOFINS") == 0)) {  
												VCOFINS = texto;
												controleVCOFINS = false;
											}
										}
									}
									if(controleCOFINSNT){
										if(controleCST){
											if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
												CST = texto;
												controleCST = false;
											}
										}
									}
									if(controleCOFINSOUTR){
										if(controleCST || controleQBCPROD || controleVALIQPROD || controleVCOFINS){
											if ((tagAtual.compareToIgnoreCase("CST") == 0)) {  
												CST = texto;
												controleCST = false;
											}
											if ((tagAtual.compareToIgnoreCase("qBCProd") == 0)) {  
												QBCPROD = texto;
												controleQBCPROD = false;
											}
											if ((tagAtual.compareToIgnoreCase("vAliqProd") == 0)) {  
												VALIQPROD = texto;
												controleVALIQPROD = false;
											}
											if ((tagAtual.compareToIgnoreCase("vCOFINS") == 0)) {  
												VCOFINS = texto;
												controleVCOFINS = false;
											}
										}
									}
									if(controleCOFINSST){
										if(controleVBC || controlePCOFINS || controleQBCPROD || controleVALIQPROD){
											if ((tagAtual.compareToIgnoreCase("vBC") == 0)) {  
												VBC = texto;
												controleVBC = false;
											}
											if ((tagAtual.compareToIgnoreCase("pCOFINS") == 0)) {  
												PCOFINS = texto;
												controlePCOFINS = false;
											}
											if ((tagAtual.compareToIgnoreCase("qBCProd") == 0)) {  
												QBCPROD = texto;
												controleQBCPROD = false;
											}
											if ((tagAtual.compareToIgnoreCase("vAliqProd") == 0)) {  
												VALIQPROD = texto;
												controleVALIQPROD = false;
											}
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
	   
	private String gerarLayoutI9(String cNPJEMITENTE, String CNPJDESTINATARIO, String MODELO, String NUMERONF, String SERIE, String DATAHORAEMISSAO, 
								 String DATAENTRADASAIDA, String TIPONF, String IDDESTINATARIO, String TIPOEMISSAO, String CODIGOPRODUTO, 
								 String CODIGODEBARRAS, String NOMEPRODUTO, String NCM, String CODIGOFISCAL, String UNIDADECOMERCIAL, 
								 String QUANTIDADECOMERCIAL, String VALORUNITARIO, String VALORTOTALPROD, String CODIGODEBARRASTRIB, 
								 String ORIGEM, String CST, String MODBC, String VBC, String PICMS, String VICMS, String MODBCST, String VBCST, 
								 String PICMSST, String VICMSST, String VICMSOP, String PBCOP, String UFST, String VBCSTRET, String VICMSSTRET,
								 String CSOSN, String PCREDSN, String VCREDICMSSN, String PIPI, String QUNID, String VUNID, String VIPI, String PPIS,
								 String VPIS, String QBCPROD, String VALIQPROD, String PCOFINS, String VCOFINS) {
	   
	   //System.out.println("TESTE: "+cNPJEMITENTE);
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	   String dataEmissaoCon[] = DATAHORAEMISSAO.split("T");
	   
	   String dataEmissaoFormat = dataEmissaoCon[0].substring(8,10)+"/"+dataEmissaoCon[0].substring(5,7)+"/"+dataEmissaoCon[0].substring(0,4);
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
		System.out.println(CST);
		System.out.println(MODBC);
		System.out.println(VBC);
		System.out.println(PICMS);
		System.out.println(VICMS);
		System.out.println(MODBCST);
		System.out.println(VBCST);
		System.out.println(PICMSST);
		System.out.println(VICMSST);
		System.out.println(VICMSOP);
		System.out.println(PBCOP);
		System.out.println(UFST);
		System.out.println(VBCSTRET);
		System.out.println(VICMSSTRET);
		System.out.println(CSOSN);
		System.out.println(PCREDSN);
		System.out.println(VCREDICMSSN);
		
		
		
		return "";
	}

	public static void main(String[] args) {
		File arquivo = new File("C:\\i9\\nota.xml");
		LeitorDeXML leitor = new LeitorDeXML();
		leitor.lerXML(arquivo);
	}	
}
