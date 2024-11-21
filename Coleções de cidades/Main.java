import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Estrutura 1: Agrupamento por UF sem repetição de UFs
        Map<String, Set<Cidade>> cidadesPorUF = new TreeMap<>();
        adicionarCidades(cidadesPorUF);

        System.out.println("Cidades agrupadas por UF (ordem alfabética):");
        for (Map.Entry<String, Set<Cidade>> entry : cidadesPorUF.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Estrutura 2: Imprimir capitais primeiro e depois por ordem alfabética
        System.out.println("\nCidades com capitais primeiro (ordem alfabética):");
        List<Cidade> todasCidades = new ArrayList<>();
        cidadesPorUF.values().forEach(todasCidades::addAll);

        todasCidades.sort(Comparator.comparing(Cidade::isCapital).reversed()
                .thenComparing(Cidade::getNome));
        todasCidades.forEach(System.out::println);

        // Estrutura 3: Conjunto de cidades com ordem decrescente
        Set<Cidade> conjuntoCidades = new TreeSet<>(Comparator.comparing(Cidade::getNome).reversed());
        todasCidades.forEach(conjuntoCidades::add);

        System.out.println("\nCidades em ordem alfabética decrescente:");
        conjuntoCidades.forEach(System.out::println);
    }

    private static void adicionarCidades(Map<String, Set<Cidade>> cidadesPorUF) {
        adicionarCidade(cidadesPorUF, "GO", new Cidade("Anápolis", false));
        adicionarCidade(cidadesPorUF, "GO", new Cidade("Goiânia", true));
        adicionarCidade(cidadesPorUF, "SP", new Cidade("Ribeirão Preto", false));
        adicionarCidade(cidadesPorUF, "SP", new Cidade("Campinas", false));
        adicionarCidade(cidadesPorUF, "MG", new Cidade("Belo Horizonte", true));
        adicionarCidade(cidadesPorUF, "MG", new Cidade("Uberlândia", false));
        adicionarCidade(cidadesPorUF, "MG", new Cidade("Montes Claros", false));
        adicionarCidade(cidadesPorUF, "MG", new Cidade("Unaí", false));
        adicionarCidade(cidadesPorUF, "TO", new Cidade("Palmas", true));
        adicionarCidade(cidadesPorUF, "TO", new Cidade("Araguarí", false));
        adicionarCidade(cidadesPorUF, "MT", new Cidade("Cuiabá", true));
        adicionarCidade(cidadesPorUF, "MS", new Cidade("Dourados", false));
        adicionarCidade(cidadesPorUF, "MS", new Cidade("Campo Grande", true));
        adicionarCidade(cidadesPorUF, "MS", new Cidade("Corumbá", false));
        adicionarCidade(cidadesPorUF, "MT", new Cidade("Barra do Garças", false));
        adicionarCidade(cidadesPorUF, "MT", new Cidade("Araguaiana", false));
        adicionarCidade(cidadesPorUF, "RO", new Cidade("Porto Velho", true));
        adicionarCidade(cidadesPorUF, "RO", new Cidade("Costa Marques", false));
    }

    private static void adicionarCidade(Map<String, Set<Cidade>> cidadesPorUF, String uf, Cidade cidade) {
        cidadesPorUF.putIfAbsent(uf, new TreeSet<>());
        cidadesPorUF.get(uf).add(cidade);
    }
}
