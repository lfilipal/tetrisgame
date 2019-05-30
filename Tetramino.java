package cg2dtetris;

import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Random;
import java.awt.BasicStroke;
import java.awt.Color;

public class Tetramino {
	private int tamanhoQuadrado;
	private int x;
	private int y;
	private Color cor;
	private int[][] forma;
	private boolean rotacao;
	
	private static final int STROKE_SIZE = 2; // definir 2px de stroke; final porque são constantes, não queremos que mudem mais; 
	private static final Color[] CORES = {Color.red, Color.green, Color.cyan, Color.yellow, Color.pink, Color.gray}; // definição do array de cores possiveis que vão ser atribuidas aleatoriamente aos tetraminos; 
	
	//definição das formas dos tetraminos propriamente ditos. São definidos num array bidimensional em que cada unidade base é um quadrado com 20px de largura/altura; 
	private static final int[][] FORMA_Z = {{0,0}, {1,0}, {1,1}, {2,1}}; // definição da posição dos quadrados pintados na forma z; 
	private static final int[][] FORMA_S = {{1,0}, {2,0}, {0,1}, {1,1}}; // definição da posição dos quadrados pintados na forma S;
	private static final int[][] FORMA_I = {{0,0}, {0,1}, {0,2}, {0,3}}; // definição da posição dos quadrados pintados na forma I;
	private static final int[][] FORMA_L = {{0,0}, {0,1}, {0,2}, {1,2}}; // definição da posição dos quadrados pintados na forma L;
	private static final int[][] FORMA_J = {{1,0}, {1,1}, {1,2}, {0,2}}; // definição da posição dos quadrados pintados na forma J;
	private static final int[][] FORMA_Q = {{0,0}, {0,1}, {1,0}, {1,1}}; // definição da posição dos quadrados pintados na forma Q;
	
	private static final int[][][] FORMAS = {FORMA_Z, FORMA_S, FORMA_I, FORMA_L, FORMA_J, FORMA_Q}; //array que contem as formas todas para depois decidir qual das formas vai aparecer; 
	
	Tetramino(int tamanhoQuadrado) {
		Random aleatCor = new Random(); //atribuição da cor à peça de forma aleatória; 
		int aleatCorIndex = aleatCor.nextInt(CORES.length);
		
		Random aleatForma = new Random(); //atribuição da forma à peça de forma aleatória; 
		int aleatFormaIndex = aleatForma.nextInt(FORMAS.length);
		
		System.out.println("FORMA " + aleatFormaIndex); //impressão na consola para mostrar qual a forma que se está a desenhar; 
		
		this.tamanhoQuadrado = tamanhoQuadrado;
		this.forma = FORMAS[aleatFormaIndex];  
		this.cor = CORES[aleatCorIndex];
		this.x = 0; //ponto inicial da forma em X; 
		this.y = 0; //ponto inicial da forma em Y;
		this.rotacao = false; //a peça não está rodada no inicio do jogo, está na sua forma original; 
	}
	
	void setX(int x) { //quando se quiser de futuro definir em X a posição da forma; 
		this.x = x;
	}
	
	void setY(int x) { //quando se quiser de futuro definir em X a posição da forma;
		this.x = x;
	}
	
	void desenha(Graphics2D g2d) {
		
		//Definição do Stroke - grossura, terminações, forma como se juntam os traços..
		Stroke stroke = new BasicStroke(STROKE_SIZE,
		           BasicStroke.CAP_BUTT,
		           BasicStroke.JOIN_ROUND);
		g2d.setStroke(stroke);
		
		//ciclo que permite desenhar cada quadrado que compõe o tetramino; 
		
		for(int i = 0; i < this.forma.length; i+=1) { // controla um quadrado do tetramino que se está a desenhar; 
			int drawRectX = this.x + this.forma[i][0] * this.tamanhoQuadrado; //definir a coordenada em X do quadrado;
			int drawRectY = this.y + this.forma[i][1] * this.tamanhoQuadrado; //definir a coordenada em Y do quadrado;
			System.out.println("QUAD " + i);
			System.out.println("  x: " + drawRectX);
			System.out.println("  y: " + drawRectY);
			int tam = this.tamanhoQuadrado - STROKE_SIZE; // cálculo do tamanho do fill;
			g2d.setColor(Color.black); // definição da cor do stroke; 
			g2d.drawRect(drawRectX, drawRectY, this.tamanhoQuadrado, this.tamanhoQuadrado); //desenho do stroke do quadrado; 
			g2d.setColor(this.cor);
			g2d.fillRect(drawRectX + STROKE_SIZE / 2, drawRectY + STROKE_SIZE / 2, tam, tam); // ?? Não percebo porque só funciona se dividir por 2... corresponde ao desenho do fill do quadrado.
		}
	}
}
