
package org.example.assignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.List;

public class HelloController {
    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TextField yearField;

    @FXML
    private CheckBox yearCheckBox;

    @FXML
    private VBox chartContainer;

    @FXML
    private TableView<Game> tableView;

    @FXML
    private TableColumn<Game, String> titleColumn;

    @FXML
    private TableColumn<Game, String> platformColumn;

    @FXML
    private TableColumn<Game, Integer> yearColumn;

    @FXML
    private TableColumn<Game, String> genreColumn;

    @FXML
    private TableColumn<Game, String> publisherColumn;

    @FXML
    private TableColumn<Game, Float> salesColumn;

    @FXML
    private Button switchToChartViewButton;

    public void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("platform"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));

        loadChartData();
        loadTableData();
    }

    private void loadChartData() {
        try {
            List<Game> games = DBUtility.getGames();
            XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
            dataSeries.setName("Sales Data");

            for (Game game : games) {
                dataSeries.getData().add(new XYChart.Data<>(game.getTitle(), game.getSales()));
            }

            barChart.getData().clear();
            barChart.getData().add(dataSeries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadTableData() {
        try {
            List<Game> games = DBUtility.getGames();
            ObservableList<Game> gameList = FXCollections.observableArrayList(games);
            tableView.setItems(gameList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadChartDataByYear() {
        try {
            int year = Integer.parseInt(yearField.getText());
            List<Game> games = DBUtility.getGamesByYear(year);
            XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
            dataSeries.setName("Sales Data " + year);

            for (Game game : games) {
                dataSeries.getData().add(new XYChart.Data<>(game.getTitle(), game.getSales()));
            }

            barChart.getData().clear();
            barChart.getData().add(dataSeries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void toggleYear() {
        if (yearCheckBox.isSelected()) {
            yearField.setDisable(false);
        } else {
            yearField.setDisable(true);
        }
    }

    @FXML
    private void switchToTableView() {
        barChart.setVisible(false);
        tableView.setVisible(true);
        switchToChartViewButton.setVisible(true);
    }

    @FXML
    private void switchToChartView() {
        barChart.setVisible(true);
        tableView.setVisible(false);
        switchToChartViewButton.setVisible(false);
    }
}