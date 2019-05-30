package cg2dtetris;

import javax.swing.JFrame;

import cg2dtetris.CG2DTetris;

public class Janela extends JFrame {
	private static final int TAMANHO_QUADRADO = 20;
	private static final int QUADRADOS_LARGURA = 10;
	private static final int QUADRADOS_ALTURA = 20;
	private static final int LARGURA_AREA = TAMANHO_QUADRADO * QUADRADOS_LARGURA;
	private static final int ALTURA_AREA = TAMANHO_QUADRADO * QUADRADOS_ALTURA;
	
	Janela() {
		add(new CG2DTetris(TAMANHO_QUADRADO));
		setTitle("CG2D Tetris");
		setSize(LARGURA_AREA,ALTURA_AREA);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Janela();
	}

}
