package gui.panels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controller.PlayerController;
import gui.GameFrame;
import model.gameitem.GameItemTypes;

public class SelectMosterPanel extends JPanel {
    private static final long serialVersionUID = 8185263432699574937L;
    private final PlayerController playerController;
    private final JPanel parentPanel;
    private String itemName;
    private final GameFrame gui;

    public SelectMosterPanel(PlayerController playerController, JPanel parentPanel, GameFrame gui) {
	this.playerController = playerController;
	this.parentPanel = parentPanel;
	this.gui = gui;
	init();
    }

    private void init() {
	CardLayout c1 = (CardLayout) this.parentPanel.getLayout();
	this.setLayout(c1);
	JPanel containerPanel = new JPanel(new BorderLayout());
	List<Integer> monsterIds = this.playerController.getMonstersId();

	JPanel allMonsterPanel = new JPanel(new GridLayout(6, 2));
	for (int monsterId : monsterIds) {
	    JLabel singleMonsterLabel = new JLabel();
	    String stats = "<html>" + "name : " + this.playerController.getMonsterNameById(monsterId) + "<br/>"
		    + "Level : " + playerController.getMonsterLevel(monsterId) + "<br/>" + "Hp : "
		    + playerController.getMonsterHealth(monsterId) + "/"
		    + playerController.getMonsterMaxHealth(monsterId) + "</html>";
	    singleMonsterLabel.setText(stats);
	    setLabelProp(singleMonsterLabel);

	    JButton checkButton = new JButton("USE ON THIS MONSTER");
	    checkButton.addActionListener(e -> {
		if (this.playerController.canEvolveByItem(itemName, monsterId)) {
		    this.playerController.evolveByItem(itemName, monsterId);
		    this.playerController.useItemOnMonster(this.itemName, monsterId);
		    update();
		} else {
		    this.playerController.useItemOnMonster(this.itemName, monsterId);
		    update();
		}

		// se è di tipo evoluzione uso l'oggetto , update e cambio pannello
		// e da game frame cambio pagina a evolution panel, poi torno al bag
	    });

	    allMonsterPanel.add(singleMonsterLabel);
	    allMonsterPanel.add(checkButton);
	}

	JButton backButton = new JButton("BACK");
	backButton.addActionListener(e -> c1.show(this.parentPanel, "ITEMS"));

	containerPanel.add(allMonsterPanel, BorderLayout.CENTER);
	containerPanel.add(backButton, BorderLayout.SOUTH);
	this.add(containerPanel);

    }

    public void setItemName(String ItemName) {
	this.itemName = ItemName;
    }

    private void update() {
	this.removeAll();
	init();
    }

    private void setLabelProp(JLabel label) {
	label.setLayout(new BorderLayout());
	label.setBorder(BorderFactory.createLineBorder(Color.blue));
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setVerticalAlignment(SwingConstants.CENTER);
    }

}