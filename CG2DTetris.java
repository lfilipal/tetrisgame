package cg2dtetris;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import cg2dtetris.Tetramino;

public class CG2DTetris extends JPanel implements KeyListener {
	private int tamanhoQuadrado;
	private Tetramino pecaActual;
	
	CG2DTetris(int tamanhoQuadrado) {
		this.tamanhoQuadrado = tamanhoQuadrado;
		addKeyListener(this);
		setFocusable(true);
		this.pecaActual = new Tetramino(this.tamanhoQuadrado);  
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.pecaActual.desenha(g2d);
	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		switch(tecla.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			break;
		case KeyEvent.VK_RIGHT:
			break;
		case KeyEvent.VK_UP:
			break;
		case KeyEvent.VK_DOWN:
			break;
		case KeyEvent.VK_SPACE:
			break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// j.idle();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
