package net.renkin42.faintWish.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;

public class InternalDisplay extends JTextPane {
	
	private static final long serialVersionUID = 1L;
	
	private static final String START_TAGS = "<html><head><meta charset=\"UTF-8\" />"
			+ "<style>body {color:white; background-color:black; font-family:monospace;"
			+ "margin:0; padding:0;}</style></head><body><pre>";
	private static final String END_TAGS = "</pre></body></html>";
	private String content;
	
	public InternalDisplay(int width, int height) {
		super();
		this.content = "";
		this.setText(START_TAGS+content+END_TAGS);
		this.setContentType("text/html");
		this.setPreferredSize(new Dimension(width, height));
	}
	
	/**
	 * Adds the input String to the body of the <code>JTextPane</code>'s HTML document 
	 * without additional formatting.
	 * @param input String to be added.
	 */
	public void print(String input) {
		this.content += input;
		this.setText(START_TAGS+content+END_TAGS);
	}
	
	/**
	 * Adds the input String to the body of the <code>JTextPane</code>'s HTML document 
	 * with an additional {@code<br>} tag appended at the end.
	 * @param input String to be added.
	 */
	public void println(String input) {
		this.content += input+"<br>";
		this.setText(START_TAGS+content+END_TAGS);
	}
	
	/**
	 * Appends a {@code<br>} tag to the end of the body of the <code>JTextPane</code>'s 
	 * HTML document.
	 */
	public void println() {
		this.content += "<br>";
		this.setText(START_TAGS+content+END_TAGS);
	}
	
	/**
	 * Adds a {@code<span>} element to the <code>JTextPane</code>'s HTML document 
	 * containing the input String which uses CSS to set the color using rgb values.
	 * @param input text to be added
	 * @param color color of text
	 */
	public void printc(String input, Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		this.content += "<span style=\"color:rgb("+r+","+g+","+b+")\">"+input+"</span>";
		this.setText(START_TAGS+content+END_TAGS);
	}
	
	/**
	 * Adds a {@code<span>} element to the <code>JTextPane</code>'s HTML document containing 
	 * the input String which interprets the second string as a CSS stylesheet. For example,
	 * to display "Hello World" in 20 pt Comic Sans, you would use <code>prints("Hello World", 
	 * "font-size:20pt;font-family:\"Comic Sans\";")</code>.
	 * @param input text to be added
	 * @param style css stylesheet
	 */
	public void prints(String input, String style) {
		this.content += "<span style=\""+style+"\">"+input+"</span>";
		this.setText(START_TAGS+content+END_TAGS);
	}
	
	public void append(String input) {
		this.content += input;
	}
	
	public void appendln(String input) {
		this.content += input + "<br>";
	}
	
	public void appendln() {
		this.content += "<br>";
	}
	
	public void appendc(String input, Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		this.content += "<span style=\"color:rgb("+r+","+g+","+b+")\">"+input+"</span>";
	}
	
	public void appends(String input, String style) {
		this.content += "<span style=\""+style+"\">"+input+"</span>";
	}
	
	/**
	 * Resets the body of the <code>JTextPane</code>'s HTML document to an empty string.
	 */
	public void clear() {
		this.content = "";
		this.setText(START_TAGS+content+END_TAGS);
	}
}
