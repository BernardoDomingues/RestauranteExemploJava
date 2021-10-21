package main;

public interface Painels {
    public void mineMenu();
    public void payment();
    public void actionsByChoice();
    public void validadeRetireNumber(String inputClientNumber) throws Validations;
    public void validadePaymentNumber(String inputClientNumber) throws Validations;
    public void validadeCreditCardNumber(String inputClientNumber) throws Validations;
    public void withdrawal();
    public void choiceFood();
}
