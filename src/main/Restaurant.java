package main;
import javax.swing.*;

public class Restaurant implements Painels {
    String[] options = {"Realizar Pedido", "Receber Pedido", "Pagar"};
    private double choice;
    private int[] askArr = new int[25];
    private int numberAsk = 0;
    private String[] menu = {"Pizza", "Salada", "Sorvete", "Hamburger"};
    String message = "Seu Número de pedido é: ";
    String message1 = "Voce retirou ";
    String messageError;

    public void setChoice(double choice) {
        this.choice = choice;
    }
    public double getChoice() {
        return choice;
    }

    @Override
    public void validadeAskNumber(String inputClientNumber) throws Validations {
        // if (inputClientNumber == "") {
        //     messageError = "Nenhum dado foi inserido";
        //     throw new Validations("O Cliente tentou retirar um pedido, porém, não digitou o número do pedido.");
        // }
        int translateInput = Integer.parseInt(inputClientNumber);
        if (numberAsk == 0) {
            messageError = "Nenhum pedido ainda foi feito!";
            throw new Validations("O Cliente tentou retirar um pedido, porém, ainda não temos pedidos registrados.");
        }
        if ((translateInput - 1) > numberAsk) {
            messageError = "Número de pedido inexistente!";
            throw new Validations("O Cliente tentou retirar um pedido, porém, o número do pedido não existe.");
        }
        JOptionPane.showMessageDialog(null, message1.concat(menu[askArr[translateInput - 1]]), "Retirada de Pedido", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mineMenu() {
		int x = JOptionPane.showOptionDialog(null, "Bem-vindo, em que posso ajudar?",
				"Restaurante Exemplo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		setChoice(x);
		actionsByChoice();
    }

    @Override
    public void payment() {
        JOptionPane.showInputDialog("Digite o número do pedido");
        mineMenu();
    }
    @Override
    public void choiceFood() {
        int selectedProduc = JOptionPane.showOptionDialog(null, "Escolha um produto",
            "Restaurante Exemplo",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu, menu[0]);
        askArr[numberAsk] = selectedProduc;
        JOptionPane.showMessageDialog(null, message.concat(Integer.toString(numberAsk + 1)), "Número do Pedido", JOptionPane.INFORMATION_MESSAGE);
        numberAsk++;
        mineMenu();
    }
    
    @Override
    public void withdrawal() {
        final String askNumber = JOptionPane.showInputDialog("Digite o número do pedido");
        try {
            validadeAskNumber(askNumber);
        } catch (Validations e) {
            JOptionPane.showMessageDialog(null, messageError, "Retirada de Pedido", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        mineMenu();
    }

    @Override
    public void actionsByChoice() {
        if (choice == 0.0) {
            choiceFood();
        } else if (choice == 1.0) {
            withdrawal();
        } else if (choice == 2.0) {
            payment();
        }
    }
}
