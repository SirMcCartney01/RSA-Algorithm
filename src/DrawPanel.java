import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by cesar on 24/04/17.
 */
public class DrawPanel extends JPanel {


    public DrawPanel() {
        initPanel(this);
    }

    private void initPanel(JPanel panel) {


        JScrollPane scrollMain = new JScrollPane(panel);
        scrollMain.setBounds(1920, 1080, 220, 35);
        panel.setBackground(Color.GRAY);

        /**
         * Initializing all components
         * Labels, text fields, text areas, scrolls and buttons
         * */

        //Labels
        JLabel title = new JLabel();
        JLabel genRandPrimes = new JLabel();
        JLabel encodeDecode = new JLabel();
        JLabel sizePrime = new JLabel();
        JLabel primeNumberP = new JLabel();
        JLabel primeNumberQ = new JLabel();
        JLabel factorizeTitle = new JLabel();
        JLabel moduleN = new JLabel();
        JLabel totient = new JLabel();
        JLabel publicKeyE = new JLabel();
        JLabel privateKeyD = new JLabel();
        JLabel typeText = new JLabel();
        JLabel resultingText = new JLabel();

        //Text fields
        JTextField primeSize = new JTextField();
        JTextField primeP = new JTextField();
        JTextField primeQ = new JTextField();
        JTextField nModule = new JTextField();
        JTextField totientFunction = new JTextField();
        JTextField publicKey = new JTextField();
        JTextField privateKey = new JTextField();

        //Text areas
        JTextArea inputText = new JTextArea();
        JTextArea outputText = new JTextArea();

        //Scrolls
        JScrollPane inputScroll = new JScrollPane(inputText);
        JScrollPane outputScroll = new JScrollPane(outputText);

        //Buttons
        JButton generatePrimes = new JButton("Generar primos");
        JButton solve = new JButton("Resolver");
        JButton execute = new JButton("Ejecutar");
        JButton openFile = new JButton("Abrir archivo");
        JButton clearAll = new JButton("Borrar todo");

        //Radio button
        JRadioButton encode = new JRadioButton();
        JRadioButton decode = new JRadioButton();


        /**
         * Setting bounds to all components
         * Labels, text fields, scrolls and buttons
         * */

        //Labels
        title.setBounds(new Rectangle(900, 10, 220, 45));
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 50));
        title.setPreferredSize(new Dimension(200, 200));
        title.setText("RSA");

        genRandPrimes.setBounds(new Rectangle(20, 80, 520, 45));
        genRandPrimes.setFont(new Font(genRandPrimes.getFont().getName(), Font.BOLD, 20));
        genRandPrimes.setPreferredSize(new Dimension(200, 200));
        genRandPrimes.setText("GENERAR PRIMOS ALEATORIOS");

        encodeDecode.setBounds(new Rectangle(980, 80, 520, 45));
        encodeDecode.setFont(new Font(encodeDecode.getFont().getName(), Font.BOLD, 20));
        encodeDecode.setPreferredSize(new Dimension(200, 200));
        encodeDecode.setText("CODIFICAR / DECODIFICAR");

        sizePrime.setBounds(new Rectangle(20, 125, 220, 21));
        sizePrime.setFont(new Font(sizePrime.getFont().getName(), sizePrime.getFont().getStyle(), 20));
        sizePrime.setPreferredSize(new Dimension(200, 200));
        sizePrime.setText("Numero de digitos:");

        primeNumberP.setBounds(new Rectangle(20, 155, 220, 21));
        primeNumberP.setFont(new Font(primeNumberP.getFont().getName(), primeNumberP.getFont().getStyle(), 20));
        primeNumberP.setPreferredSize(new Dimension(200, 200));
        primeNumberP.setText("Número primo P:");

        primeNumberQ.setBounds(new Rectangle(20, 185, 220, 21));
        primeNumberQ.setFont(new Font(primeNumberQ.getFont().getName(), primeNumberQ.getFont().getStyle(), 20));
        primeNumberQ.setPreferredSize(new Dimension(200, 200));
        primeNumberQ.setText("Número primo Q:");

        factorizeTitle.setBounds(new Rectangle(20, 320, 220, 50));
        factorizeTitle.setFont(new Font(factorizeTitle.getFont().getName(), Font.BOLD, 20));
        factorizeTitle.setPreferredSize(new Dimension(200, 200));
        factorizeTitle.setText("FACTORIZACIÓN");

        moduleN.setBounds(new Rectangle(20, 370, 220, 21));
        moduleN.setFont(new Font(moduleN.getFont().getName(), moduleN.getFont().getStyle(), 20));
        moduleN.setPreferredSize(new Dimension(200, 200));
        moduleN.setText("Módulo n = p*q:");

        totient.setBounds(new Rectangle(20, 410, 220, 21));
        totient.setFont(new Font(totient.getFont().getName(), totient.getFont().getStyle(), 20));
        totient.setPreferredSize(new Dimension(200, 200));
        //totient.setText("Función indicatriz:");fi: fi(n)=(p-1)(q-1)
        totient.setText("fi(n)=(p-1)(q-1):");

        publicKeyE.setBounds(new Rectangle(20, 450, 220, 21));
        publicKeyE.setFont(new Font(publicKeyE.getFont().getName(), publicKeyE.getFont().getStyle(), 20));
        publicKeyE.setPreferredSize(new Dimension(200, 200));
        publicKeyE.setText("Clave publica:");

        privateKeyD.setBounds(new Rectangle(20, 490, 220, 21));
        privateKeyD.setFont(new Font(privateKeyD.getFont().getName(), privateKeyD.getFont().getStyle(), 20));
        privateKeyD.setPreferredSize(new Dimension(200, 200));
        privateKeyD.setText("Clave privada:");

        typeText.setBounds(new Rectangle(980, 120, 420, 21));
        typeText.setFont(new Font(typeText.getFont().getName(), typeText.getFont().getStyle(), 20));
        typeText.setPreferredSize(new Dimension(200, 200));
        typeText.setText("Escriba el texto a encriptar/desencriptar:");

        resultingText.setBounds(new Rectangle(980, 560, 420, 21));
        resultingText.setFont(new Font(resultingText.getFont().getName(), resultingText.getFont().getStyle(), 20));
        resultingText.setPreferredSize(new Dimension(200, 200));
        resultingText.setText("Salida c=m^e(mod n):");


        //TextFields
        primeSize.setBounds(210, 125, 150, 30);
        primeP.setBounds(210, 155, 700, 30);
        primeQ.setBounds(new Rectangle(210, 185, 700, 30));
        nModule.setBounds(new Rectangle(210, 370, 700, 30));
        totientFunction.setBounds(new Rectangle(210, 410, 700, 30));
        publicKey.setBounds(new Rectangle(210, 450, 700, 30));
        privateKey.setBounds(new Rectangle(210, 490, 700, 30));

        //Scrolls
        inputScroll.setBounds(980, 150, 900, 400);
        outputScroll.setBounds(980, 590, 900, 400);


        //Buttons
        generatePrimes.setBounds(450, 220, 220, 35);
        solve.setBounds(250, 550, 220, 35);
        openFile.setBounds(1600, 105, 150, 35);
        execute.setBounds(1750, 105, 150, 35);
        clearAll.setBounds(20, 960, 150, 35);

        //Radio buttons
        encode.setText("Codificar");
        decode.setText("Decodificar");
        ButtonGroup option = new ButtonGroup();
        option.add(encode);
        option.add(decode);
        encode.setBounds(1500, 100, 100, 30);
        encode.setSelected(true);
        decode.setBounds(1500, 120, 100, 30);


        /**
         * Printing all the components
         * */
        panel.setLayout(null);
        panel.add(title);
        panel.add(genRandPrimes);
        panel.add(encodeDecode);
        panel.add(sizePrime);
        panel.add(primeSize);
        panel.add(primeNumberP);
        panel.add(primeNumberQ);
        panel.add(primeP);
        panel.add(primeQ);
        panel.add(generatePrimes);
        panel.add(factorizeTitle);
        panel.add(moduleN);
        panel.add(nModule);
        panel.add(totient);
        panel.add(totientFunction);
        panel.add(publicKeyE);
        panel.add(publicKey);
        panel.add(privateKeyD);
        panel.add(privateKey);
        panel.add(solve);
        panel.add(typeText);
        panel.add(resultingText);
        panel.add(inputScroll);
        panel.add(outputScroll);
        panel.add(encode);
        panel.add(decode);
        panel.add(openFile);
        panel.add(execute);
        panel.add(clearAll);


        /**
         * Action Listeners for buttons
         */
        //Generate prime numbers
        generatePrimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /**
                 *
                 * */
                int size;
                try {
                    size = Integer.parseInt(primeSize.getText());
                    if (size < 0) {
                        JOptionPane.showMessageDialog(null, "Valor no valido", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        RSA rsa = new RSA(size * 3);
                        primeP.setText("" + rsa.getP());
                        primeQ.setText("" + rsa.getQ());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor no valido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            /**
             * Test Factor
             * */

        });

        //Solve
        solve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int size = 0;
                try {
                    size = Integer.parseInt(primeSize.getText());
                    if (size < 0) {
                        JOptionPane.showMessageDialog(null, "Valor no valido", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor no valido", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!primeP.getText().isEmpty() && !primeQ.getText().isEmpty()) {
                    BigInteger p = new BigInteger(primeP.getText());
                    BigInteger q = new BigInteger(primeQ.getText());
                    cypherRSA = new RSA(p, q, size * 3);
                    privateKey.setText("" + cypherRSA.getD());
                    publicKey.setText("" + cypherRSA.getE());
                    nModule.setText("" + cypherRSA.getP());
                    totientFunction.setText("" + cypherRSA.getIndicatriz());
                } else {
                    JOptionPane.showMessageDialog(null, "Falta generar los valores P y Q!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String fileName = JOptionPane.showInputDialog(null,"Escriba el nombre del archivo");
                String rout = "/home/cesar/Documents/FCC/Primavera 2017/Analisis y Diseño de Algoritmos/Proyecto Final/src/"+fileName;

                String line;

                try {
                    FileReader fileReader =
                            new FileReader(rout);

                    BufferedReader bufferedReader =
                            new BufferedReader(fileReader);

                    while((line = bufferedReader.readLine()) != null) {
                        inputText.append(line+"\n");
                    }
                    bufferedReader.close();
                }
                catch(FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"No existe el archivo "+fileName, "Error!",JOptionPane.ERROR_MESSAGE);
                }
                catch(IOException ex) {
                    JOptionPane.showMessageDialog(null,"No existe el archivo "+fileName, "Error!",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Encode - Decode
        execute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (encode.isSelected()) {
                    BigInteger[] textoCifrado = cypherRSA.encripta(inputText.getText());
                    outputText.setText("");
                    for (int i = 0; i < textoCifrado.length; i++) {
                        outputText.setText(outputText.getText() + textoCifrado[i].toString() + "\n");
                        if (i != textoCifrado.length - 1)
                            outputText.setText(outputText.getText() + "");
                    }
                } else {
                    String letra;

                    StringTokenizer st = new StringTokenizer(inputText.getText());
                    BigInteger[] textoCifrado = new BigInteger[st.countTokens()];

                    for (int i = 0; i < textoCifrado.length; i++) {
                        letra = st.nextToken();
                        textoCifrado[i] = new BigInteger(letra);
                    }
                    outputText.setText(cypherRSA.desencripta(textoCifrado));
                }
            }
        });

        //Clears all data
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                primeSize.setText(null);
                primeP.setText(null);
                primeQ.setText(null);
                nModule.setText(null);
                totientFunction.setText(null);
                publicKey.setText(null);
                privateKey.setText(null);
                inputText.setText(null);
                outputText.setText(null);
            }
        });
    }
    private RSA cypherRSA;
}
