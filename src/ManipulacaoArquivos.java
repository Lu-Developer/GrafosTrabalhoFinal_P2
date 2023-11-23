import model.Grafo;
import model.Vertice;

import java.io.*;

public class ManipulacaoArquivos {

    public static void criarDiretorios(String diretorioAtual, String pastaPrincipal, String sucesso, String erro, boolean rotaAutomatica) throws Exception {
        String configuracaoPath = pastaPrincipal + File.separator + "Configs";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(diretorioAtual+File.separator+"config.txt"));
            String line;

            criarDiretorio(sucesso);
            criarDiretorio(erro);
        } catch (FileNotFoundException e) {
            criarDiretorio(configuracaoPath);
            criarArquivoConfig(diretorioAtual, pastaPrincipal, sucesso, erro, rotaAutomatica);
            criarDiretorios(diretorioAtual, pastaPrincipal, sucesso, erro, rotaAutomatica);
        }
    }

    public static void criarArquivoConfig(String diretorioAtual, String pastaPrincipal, String pastaSucesso, String pastaErro, boolean rotaAutomatica) {
        File arquivo = new File(diretorioAtual+File.separator+"config.txt");
        try {
            if (arquivo.createNewFile()){
                try {
                    FileWriter writer = new FileWriter(arquivo);
                    writer.write("Principal= "+pastaPrincipal+System.lineSeparator()+
                            "Sucesso= "+pastaSucesso+System.lineSeparator()+
                            "Erro= "+pastaErro+System.lineSeparator() +
                            "Rota automatica="+ rotaAutomatica +System.lineSeparator());
                    writer.close();
                } catch (IOException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void criarDiretorio(String path) {
        File diretorio = new File(path);
        if (!diretorio.exists()) {
            if (diretorio.mkdirs()) {
                System.out.println("Diretório criado: " + path);
            } else {
                System.err.println("Erro ao criar o diretório: " + path);
            }
        }
    }

    public static void processarArquivosRota(String pastaPrincipal, String pastaSucesso, String pastaErro) {
        File[] arquivos = new File(pastaPrincipal).listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                if (arquivo.getName().startsWith("rota") && arquivo.getName().endsWith(".txt")) {
                    try {
                        processarArquivoRota(arquivo);
                        File destino = new File(pastaSucesso +File.separator+ arquivo.getName());
                        arquivo.renameTo(destino);
                    } catch (Exception e) {
                        File destino = new File(pastaErro +File.separator+ arquivo.getName());
                        arquivo.renameTo(destino);
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Nenhum arquivo de rota encontrado no caminho:\n"+
            pastaPrincipal);
        }
    }

    public static void processarArquivoRota(File arquivo) throws Exception {
        int totalNoHeader = 0;
        int totalNoArquivo = 0;
        int somaPesosHeader = 0;
        int somaPesosLinhas = 0;
        int resumoConexao = 0;
        int resumoPesos = 0;
        int somaPesosTrailer = 0;
        int caractersHeader = 0;

        Grafo grafo = new Grafo();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("00")) {
                    caractersHeader = line.length();
                    // Processar linha de cabeçalho
                    totalNoHeader = Integer.parseInt(line.substring(2,4));
                    somaPesosHeader = Integer.parseInt(line.substring(4));
                } else if (line.startsWith("01")) {
                    // Processar linha de resumo de conexões
                    String linhaNo = line.substring(2);
                    String nomeNoOrigem = linhaNo.split("=")[0];
                    String nomeNoDestino = linhaNo.split("=")[1];
                    //adiciona vertice caso não exista 
                    Vertice noOrigem, noDestino;
                    if(!grafo.hasVertice(nomeNoOrigem)){
                        noOrigem = grafo.addVertice(nomeNoOrigem);
                    } else {
                        noOrigem = grafo.getVerticeByName(nomeNoOrigem);
                    }
                    if(!grafo.hasVertice(nomeNoDestino)){
                        noDestino = grafo.addVertice(nomeNoDestino);
                    } else {
                        noDestino = grafo.getVerticeByName(nomeNoDestino);
                    }
                    totalNoArquivo++;

                    adicionaAresta(grafo, noOrigem, noDestino, 0);
                } else if (line.startsWith("02")) {
                    // Processar linha de resumo de pesos
                    String linhaPeso = line.substring(2);
                    String nomeNoOrigem = linhaPeso.split(";")[0];
                    String nomeNoDestino = linhaPeso.split(";")[1].split("=")[0];
                    String pesoArestaString = linhaPeso.split("=")[1];
                    int pesoAresta = Integer.parseInt(pesoArestaString);
                    Vertice noOrigem = grafo.getVerticeByName(nomeNoOrigem);
                    Vertice noDestino = grafo.getVerticeByName(nomeNoDestino);

                    //adicona o peso numa aresta existente
                    adicionaPesoAresta(grafo, noOrigem, noDestino, pesoAresta);
                    somaPesosLinhas += pesoAresta;
                } else if (line.startsWith("09")) {
                    // Processar linha de trailer
                    String linhaTrailer = line.substring(2);
                    String linhaRC = linhaTrailer.split(";")[0];
                    String linhaRP = linhaTrailer.split(";")[1];
                    String linhaPesoTotal = linhaTrailer.split(";")[2];
                    resumoConexao = Integer.parseInt(linhaRC.split("=")[1]);
                    resumoPesos = Integer.parseInt(linhaRP.split("=")[1]);
                } else {
                    throw new Exception("Erro ao ler linha do arquivo rota, formato da linha incompativel: "+line);
                }
            }

            if (caractersHeader > 6){
                throw new Exception("Header inválido.");
            }

            if (totalNoHeader != totalNoArquivo){
                throw new Exception("Número totais de nós inválido.");
            }

            if (somaPesosHeader != somaPesosLinhas) {
                throw new Exception("Soma dos pesos difere (Valor do Registro HEADER = "+ somaPesosHeader +" e Soma total dos Pesos = "+ somaPesosLinhas +"): ");
            }

            reader.close();
            System.out.println(grafo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void adicionaAresta(Grafo grafo, Vertice origem, 
                                        Vertice destino, int peso){
        grafo.addAresta(origem, destino, peso);
    }

    public static void adicionaPesoAresta(Grafo grafo, Vertice origem, Vertice destino, int peso){
        grafo.getAresta(origem, destino).setPeso(peso);
    }
}
