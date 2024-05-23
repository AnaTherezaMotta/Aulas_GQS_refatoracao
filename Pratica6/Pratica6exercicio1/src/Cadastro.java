import java.util.Scanner;
public class Cadastro {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        Produto[] estoque = new Produto[200];
        int numProdutos = 0;

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar roupa");
            System.out.println("2. Cadastrar casa");
            System.out.println("3. Cadastrar calçados");
            System.out.println("4. Imprimir todas as pessoas");


            System.out.println("0. Sair");

            int opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    estoque[estoque.length] = cadastrarRoupa(input, estoque, numProdutos);
                    //numProdutos++;
                    break;
                case 2:
                	estoque[estoque.length] = cadastrarCasa(input, estoque, numProdutos);
                    //numProdutos++;
                    break;
                case 3:
                	estoque[estoque.length] = cadastrarCalcado(input, estoque, numProdutos);
                    //numProdutos++;
                    break;
                case 4:
                    imprimirPessoasFisicas(cadastro, numPessoas);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void cadastarRoupa(Scanner input, Produto[] estoque, int numProdutos) {
        System.out.println("Cadastro de Roupas:");
        System.out.print("Código: ");
        int codigo = input.nextInt();
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("Valor: ");
        double valor = input.nextInt();
        System.out.print("Tipo: ");
        String tipo = input.next();

        Roupa produto = new Roupa(codigo, nome, valor, tipo);
        produto.setNome(input.nextLine());
        System.out.print("Valor: ");
        produto.setValor(input.nextLine());
        
        
        estoque[numProdutos] = produto;
        System.out.println("Pessoa física cadastrada com sucesso.");
    }

    public static void cadastrarPessoaJuridica(Scanner input, Pessoa[] cadastro, int numPessoas) {
        PessoaJuridica pessoa = new PessoaJuridica();
        System.out.println("Cadastro de Pessoa Jurídica:");
        System.out.print("Nome: ");
        pessoa.setNome(input.nextLine());
        System.out.print("CNPJ: ");
        pessoa.setCNPJ(input.nextLine());
        cadastro[numPessoas] = pessoa;
        System.out.println("Pessoa jurídica cadastrada com sucesso.");
    }

    public static void imprimirTodasAsPessoas(Pessoa[] cadastro, int numPessoas) {
        System.out.println("Todas as pessoas:");
        for (int i = 0; i < numPessoas; i++) {
            System.out.println(cadastro[i]);
        }
    }

    public static void imprimirPessoasFisicas(Pessoa[] cadastro, int numPessoas) {
        System.out.println("Pessoas Físicas:");
        for (int i = 0; i < numPessoas; i++) {
            if (cadastro[i] instanceof PessoaFisica) {
                System.out.println(cadastro[i]);
            }
        }
    }

    public static void imprimirPessoasJuridicas(Pessoa[] cadastro, int numPessoas) {
        System.out.println("Pessoas Jurídicas:");
        for (int i = 0; i < numPessoas; i++) {
            if (cadastro[i] instanceof PessoaJuridica) {
                System.out.println(cadastro[i]);
            }
        }
    }

    public static void pesquisarPessoaPorDocumento(Scanner input, Pessoa[] cadastro, int numPessoas) {
        System.out.println("Informe o CPF ou CNPJ da pessoa:");
        String documento = input.nextLine();
        for (int i = 0; i < numPessoas; i++) {
            if (cadastro[i] instanceof PessoaFisica) {
                PessoaFisica pessoa = (PessoaFisica) cadastro[i];
                if (pessoa.getCPF().equals(documento)) {
                    System.out.println("Pessoa encontrada:");
                    System.out.println(pessoa);
                    return;
                }
            } else if (cadastro[i] instanceof PessoaJuridica) {
                PessoaJuridica pessoa = (PessoaJuridica) cadastro[i];
                if (pessoa.getCNPJ().equals(documento)) {
                    System.out.println("Pessoa encontrada:");
                    System.out.println(pessoa);
                    return;
                }
            }
        }
        System.out.println("Pessoa não encontrada.");
    }

    public static void atualizarPessoaPorDocumento(Scanner input, Pessoa[] cadastro, int numPessoas) {
		System.out.println("Informe o CPF ou CNPJ da pessoa:");
        String documento = input.nextLine();
		
		for(int i=0; i<numPessoas;i++) {
			if (cadastro[i] instanceof PessoaFisica) {
                PessoaFisica pessoa = (PessoaFisica) cadastro[i];
                if (pessoa.getCPF().equals(documento)) {
					System.out.println("Informe os novos dados da pessoa: ");
					System.out.print("Nome: ");
			        pessoa.setNome(input.nextLine());
			        System.out.print("CPF: ");
			        pessoa.setCPF(input.nextLine());
			        //cadastro[numPessoas] = pessoa;
					System.out.println("Pessoa atualizada com sucesso!");
					return;
                }
			}else if (cadastro[i] instanceof PessoaJuridica) {
				PessoaJuridica pessoa = (PessoaJuridica) cadastro[i];
				if (pessoa.getCNPJ().equals(documento)) {
					System.out.println("Informe os novos dados da pessoa: ");
					System.out.print("Nome: ");
			        pessoa.setNome(input.nextLine());
			        System.out.print("CPF: ");
			        pessoa.setCNPJ(input.nextLine());
			        //cadastro[numPessoas] = pessoa;
					System.out.println("Pessoa atualizada com sucesso!");
					return;
                }
			}
		}
		
		System.out.println("Nenhuma pessoa encontrada.");
    }
    
    public static void excluirPessoaPorDocumento(Scanner input, Pessoa[] cadastro, int numPessoas) {
    	System.out.println("Informe o CPF ou CNPJ da pessoa:");
        String documento = input.nextLine();
		
		for (int i=0; i<numPessoas;i++) {
			if (cadastro[i] instanceof PessoaFisica) {
				PessoaFisica pessoa = (PessoaFisica) cadastro[i];
				if (pessoa.getCPF().equals(documento)) {
	                for (int j = i; j < numPessoas - 1; j++) {
	                    cadastro[j] = cadastro[j + 1];
	                }
	                cadastro[numPessoas - 1] = null; 
	                System.out.println("Pessoa excluída com sucesso!!");
	                return;
	            }
			}else if (cadastro[i] instanceof PessoaJuridica) {
                PessoaJuridica pessoa = (PessoaJuridica) cadastro[i];
                if (pessoa.getCNPJ().equals(documento)) {
                	for (int j = i; j < numPessoas - 1; j++) {
	                    cadastro[j] = cadastro[j + 1];
	                }
	                cadastro[numPessoas - 1] = null; 
	                System.out.println("Pessoa excluída com sucesso!!");
	                return;
                }
            }
            
        }
        System.out.println("Nenhuma Pessoa encontrada.");
    }
	
 }