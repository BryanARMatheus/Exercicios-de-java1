module Exercicios1 {

	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.base;
	requires java.desktop;
	requires jdk.jlink;
	requires java.sql;
	requires io.github.cdimascio.dotenv.java;
	
	opens application to javafx.graphics, javafx.fxml;
}
