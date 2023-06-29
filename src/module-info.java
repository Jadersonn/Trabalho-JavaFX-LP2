module AulaJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	
	opens entidades to javafx.base;
	opens application to javafx.graphics, javafx.fxml;
	opens controllers to javafx.fxml;
}
