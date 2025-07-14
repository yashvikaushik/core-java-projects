package dictionaryDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TreeMap;

public class FakeDictionaryGUI extends JFrame {

    private JTextField wordField;
    private JTextArea meaningField;
    private JTextArea resultArea;
    private static TreeMap<String, String> dictionary = new TreeMap<>();

    public FakeDictionaryGUI() {
        setTitle("📘 Fake Dictionary");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title
        JLabel title = new JLabel("📚 Fake Dictionary", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        mainPanel.add(title, BorderLayout.NORTH);

        // Center form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel wordLabel = new JLabel("Word:");
        wordField = new JTextField(20);
        JLabel meaningLabel = new JLabel("Meaning:");
        meaningField = new JTextArea(3, 20);
        meaningField.setLineWrap(true);
        meaningField.setWrapStyleWord(true);
        JScrollPane meaningScroll = new JScrollPane(meaningField);

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(wordLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(wordField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(meaningLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(meaningScroll, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Result area
        resultArea = new JTextArea(8, 40);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JButton displayButton = new JButton("Display All");
        JButton deleteButton = new JButton("Clear Dictionary");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        // Button actions
        addButton.addActionListener(e -> addWord());
        searchButton.addActionListener(e -> searchWord());
        displayButton.addActionListener(e -> displayDictionary());
        deleteButton.addActionListener(e -> deleteDictionary());
        exitButton.addActionListener(e -> System.exit(0));

        add(mainPanel);
        setVisible(true);
    }

    private void addWord() {
        String word = wordField.getText().trim();
        String meaning = meaningField.getText().trim();
        if (!word.isEmpty() && !meaning.isEmpty()) {
            dictionary.put(word, meaning);
            resultArea.setText("✅ Word added: " + word);
            wordField.setText("");
            meaningField.setText("");
        } else {
            resultArea.setText("⚠️ Please enter both word and meaning.");
        }
    }

    private void searchWord() {
        String word = wordField.getText().trim();
        if (dictionary.containsKey(word)) {
            resultArea.setText("📖 Meaning of '" + word + "':\n" + dictionary.get(word));
        } else {
            resultArea.setText("❌ Word not found.");
        }
    }

    private void displayDictionary() {
        if (dictionary.isEmpty()) {
            resultArea.setText("📂 Dictionary is empty.");
        } else {
            StringBuilder builder = new StringBuilder("📚 All Words in Dictionary:\n\n");
            for (String key : dictionary.keySet()) {
                builder.append("🔹 ").append(key).append(" : ").append(dictionary.get(key)).append("\n");
            }
            resultArea.setText(builder.toString());
        }
    }

    private void deleteDictionary() {
        dictionary.clear();
        resultArea.setText("🗑️ Dictionary cleared.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FakeDictionaryGUI::new);
    }
}