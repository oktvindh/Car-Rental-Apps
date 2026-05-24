
package carrentalmanagementsystem;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.util.JRLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TableCell;
import javafx.util.Callback;




public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Label username;

    @FXML
    private Button home_btn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button availableCars_btn;
    
    @FXML
    private Button customerCars_btn;

    @FXML
    private Button rentCar_btn;
    
    @FXML
    private Button invoice_btn;

    @FXML
    private Label home_availableCars;

    @FXML
    private Label home_totalIncome;

    @FXML
    private Label home_totalCustomers;

    @FXML
    private BarChart<?, ?> home_incomeChart;

    @FXML
    private LineChart<?, ?> home_customerChart;

    @FXML
    private AnchorPane availableCars_form;

    @FXML
    private TextField availableCars_carId;

    @FXML
    private TextField availableCars_brand;

    @FXML
    private TextField availableCars_model;
    
    @FXML
    private TextField availableCars_plateNumber;

    @FXML
    private ComboBox<?> availableCars_status;

    @FXML
    private ImageView availableCars_imageView;

    @FXML
    private Button availableCars_importBtn;

    @FXML
    private Button availableCars_insertBtn;

    @FXML
    private Button availableCars_updateBtn;

    @FXML
    private Button availableCars_deleteBtn;

    @FXML
    private Button availableCars_clearBtn;

    @FXML
    private TextField availableCars_price;

    @FXML
    private TableView<carData> availableCars_tableView;

    @FXML
    private TableColumn<carData, String> availableCars_col_carId;

    @FXML
    private TableColumn<carData, String> availableCars_col_brand;

    @FXML
    private TableColumn<carData, String> availableCars_col_model;
    
    @FXML
    private TableColumn<carData, String> availableCars_col_plateNumber;

    @FXML
    private TableColumn<carData, String> availableCars_col_price;

    @FXML
    private TableColumn<carData, String> availableCars_col_status;

    @FXML
    private TextField availableCars_search;
    
    @FXML
    private AnchorPane customerCars_form;
    
    @FXML
    private TableView<customerData> customer_tableView;

    @FXML
    private TableColumn<customerData, Integer> customer_col_customerId;

    @FXML
    private TableColumn<customerData, String> customer_col_firstName;

    @FXML
    private TableColumn<customerData, String> customer_col_lastName;

    @FXML
    private TableColumn<customerData, String> customer_col_gender;

    @FXML
    private TableColumn<customerData, Integer> customer_col_carId;

    @FXML
    private TableColumn<customerData, String> customer_col_brand;

    @FXML
    private TableColumn<customerData, String> customer_col_model;

    @FXML
    private TableColumn<customerData, Double> customer_col_total;

    @FXML
    private TextField customer_search;

    @FXML
    private AnchorPane rent_form;

    @FXML
    private ComboBox<?> rent_carId;

    @FXML
    private ComboBox<?> rent_brand;

    @FXML
    private ComboBox<?> rent_model;

    @FXML
    private TextField rent_firstName;

    @FXML
    private TextField rent_lastName;

    @FXML
    private ComboBox<?> rent_gender;

    @FXML
    private DatePicker rent_dateRented;

    @FXML
    private DatePicker rent_dateReturn;

    @FXML
    private Button rentBtn;

    @FXML
    private Label rent_total;

    @FXML
    private TextField rent_amount;

    @FXML
    private Label rent_balance;

    @FXML
    private AnchorPane home_form;

    @FXML
    private TableView<carData> rent_tableView;

    @FXML
    private TableColumn<carData, String> rent_col_carId;

    @FXML
    private TableColumn<carData, String> rent_col_brand;

    @FXML
    private TableColumn<carData, String> rent_col_model;
    
    @FXML
    private TableColumn<carData, String>  rent_col_plateNumber;

    @FXML
    private TableColumn<carData, String> rent_col_price;

    @FXML
    private TableColumn<carData, String> rent_col_status;
    
    @FXML
    private AnchorPane invoice_form;
    
    @FXML
    private TableView<invoiceData> invoice_tableView;

    @FXML
    private TableColumn<invoiceData, Integer> invoice_col_invoiceId;

    @FXML
    private TableColumn<invoiceData, String> invoice_col_customer;

    @FXML
    private TableColumn<invoiceData, String> invoice_col_car;

    @FXML
    private TableColumn<invoiceData, Double> invoice_col_total;

    @FXML
    private TableColumn<invoiceData, Double> invoice_col_amount;

    @FXML
    private TableColumn<invoiceData, Double> invoice_col_balance;

    @FXML
    private TableColumn<invoiceData, Date> invoice_col_date;
    
    @FXML
    private TableColumn<invoiceData, String> invoice_col_action;

//    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private Image image;

    public void homeAvailableCars(){
        
        String sql = "SELECT COUNT(id) FROM car WHERE status = 'Available'";
        
        connect = database.connectDb();
        int countAC = 0;
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countAC = result.getInt("COUNT(id)");
            }
            
            home_availableCars.setText(String.valueOf(countAC));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void homeTotalIncome(){
        String sql = "SELECT SUM(total) FROM customer";
        
        double sumIncome = 0;
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                sumIncome = result.getDouble("SUM(total)");
            }
            home_totalIncome.setText("Rp " + String.valueOf(sumIncome));
        }catch(Exception e){e.printStackTrace();}
    }
    
    
    public void homeTotalCustomers(){
        
        String sql = "SELECT COUNT(id) FROM customer";
        
        int countTC = 0;
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countTC = result.getInt("COUNT(id)");
            }
            home_totalCustomers.setText(String.valueOf(countTC));
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void homeIncomeChart(){
        
        home_incomeChart.getData().clear();
        
        String sql = "SELECT date_rented, SUM(total) FROM customer GROUP BY date_rented ORDER BY TIMESTAMP(date_rented) ASC LIMIT 6";
        
        connect = database.connectDb();
        
        try{
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            home_incomeChart.getData().add(chart);
            
        }catch(Exception e){e.printStackTrace();}
    }

    
    
    public void homeCustomerChart(){
        home_customerChart.getData().clear();
        
        String sql = "SELECT date_rented, COUNT(id) FROM customer GROUP BY date_rented ORDER BY TIMESTAMP(date_rented) ASC LIMIT 4";
        
        connect = database.connectDb();
        
        try{
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            home_customerChart.getData().add(chart);
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void availableCarAdd() {

        String sql = "INSERT INTO car (car_id, brand, model, price, status, image, date, plate_number) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (availableCars_carId.getText().isEmpty()
                    || availableCars_brand.getText().isEmpty()
                    || availableCars_model.getText().isEmpty()
                    || availableCars_status.getSelectionModel().getSelectedItem() == null
                    || availableCars_price.getText().isEmpty()
                    || getData.path == null || getData.path == ""
                    || availableCars_plateNumber.getText().isEmpty()
                    ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, availableCars_carId.getText());
                prepare.setString(2, availableCars_brand.getText());
                prepare.setString(3, availableCars_model.getText());
                prepare.setString(4, availableCars_price.getText());
                prepare.setString(5, (String) availableCars_status.getSelectionModel().getSelectedItem());

                String uri = getData.path;
                uri = uri.replace("\\", "\\\\");

                prepare.setString(6, uri);

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                prepare.setString(7, String.valueOf(sqlDate));
                prepare.setString(8, availableCars_plateNumber.getText());

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                availableCarShowListData();
                availableCarClear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCarUpdate() {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE car SET brand = '" + availableCars_brand.getText()
                    + "', model = '" + availableCars_model.getText()
                    + "', status = '" + availableCars_status.getSelectionModel().getSelectedItem()
                    + "', price = '" + availableCars_price.getText()
                    + "', plate_number = '" + availableCars_plateNumber.getText()
                    + "', image = '" + uri
                    + "' WHERE car_id = '" + availableCars_carId.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (availableCars_carId.getText().isEmpty()
                    || availableCars_brand.getText().isEmpty()
                    || availableCars_model.getText().isEmpty()
                    || availableCars_status.getSelectionModel().getSelectedItem() == null
                    || availableCars_price.getText().isEmpty()
                    || getData.path == null || getData.path == ""
                    || availableCars_plateNumber.getText().isEmpty()
                    ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Car ID: " + availableCars_carId.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    availableCarShowListData();
                    availableCarClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCarDelete() {

        String sql = "DELETE FROM car WHERE car_id = '" + availableCars_carId.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (availableCars_carId.getText().isEmpty()
                    || availableCars_brand.getText().isEmpty()
                    || availableCars_model.getText().isEmpty()
                    || availableCars_status.getSelectionModel().getSelectedItem() == null
                    || availableCars_price.getText().isEmpty()
                    || getData.path == null || getData.path == ""
                    || availableCars_plateNumber.getText().isEmpty()
                    ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Car ID: " + availableCars_carId.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    availableCarShowListData();
                    availableCarClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCarClear() {
        availableCars_carId.setText("");
        availableCars_brand.setText("");
        availableCars_model.setText("");
        availableCars_plateNumber.setText("");
        availableCars_status.getSelectionModel().clearSelection();
        availableCars_price.setText("");

        getData.path = "";

        availableCars_imageView.setImage(null);

    }

    private String[] listStatus = {"Available", "Not Available"};

    public void availableCarStatusList() {

        List<String> listS = new ArrayList<>();

        for (String data : listStatus) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        availableCars_status.setItems(listData);
    }

    public void availableCarImportImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            getData.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 116, 153, false, true);
            availableCars_imageView.setImage(image);

        }

    }

    public ObservableList<carData> availableCarListData() {

        ObservableList<carData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM car";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            carData carD;

            while (result.next()) {
                carD = new carData(result.getInt("car_id"),
                         result.getString("brand"),
                         result.getString("model"),
                         result.getDouble("price"),
                         result.getString("status"),
                         result.getString("image"),
                         result.getDate("date"),
                         result.getString("plate_number"));

                listData.add(carD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<carData> availableCarList;

    public void availableCarShowListData() {
        availableCarList = availableCarListData();

        availableCars_col_carId.setCellValueFactory(new PropertyValueFactory<>("carId"));
        availableCars_col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        availableCars_col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        availableCars_col_plateNumber.setCellValueFactory(new PropertyValueFactory<>("plateNumber"));
        availableCars_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        availableCars_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        availableCars_tableView.setItems(availableCarList);
    }

    public void availableCarSearch() {

        FilteredList<carData> filter = new FilteredList<>(availableCarList, e -> true);

        availableCars_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateCarData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCarData.getCarId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getBrand().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getModel().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getPlateNumber().toLowerCase().contains(searchKey)) {
                    return true;
                }
                else {
                    return false;
                }
            });
        });

        SortedList<carData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(availableCars_tableView.comparatorProperty());
        availableCars_tableView.setItems(sortList);

    }

    public void availableCarSelect() {
        carData carD = availableCars_tableView.getSelectionModel().getSelectedItem();
        int num = availableCars_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < - 1) {
            return;
        }

        availableCars_carId.setText(String.valueOf(carD.getCarId()));
        availableCars_brand.setText(carD.getBrand());
        availableCars_model.setText(carD.getModel());
        availableCars_plateNumber.setText(carD.getPlateNumber());
        availableCars_price.setText(String.valueOf(carD.getPrice()));

        getData.path = carD.getImage();

        String uri = "file:" + carD.getImage();

        image = new Image(uri, 116, 153, false, true);
        availableCars_imageView.setImage(image);

    }
    
    public ObservableList<customerData> customerListData() {

        ObservableList<customerData> listData
                = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            customerData custData;

            while (result.next()) {

                custData = new customerData(
                        result.getInt("customer_id"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("gender"),
                        result.getInt("car_id"),
                        result.getString("brand"),
                        result.getString("model"),
                        result.getDouble("total")
                );

                listData.add(custData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }
    
    private ObservableList<customerData> customerList;

    public void customerShowListData() {

        customerList = customerListData();

        customer_col_customerId.setCellValueFactory(
                new PropertyValueFactory<>("customerId"));

        customer_col_firstName.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));

        customer_col_lastName.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));

        customer_col_gender.setCellValueFactory(
                new PropertyValueFactory<>("gender"));

        customer_col_carId.setCellValueFactory(
                new PropertyValueFactory<>("carId"));

        customer_col_brand.setCellValueFactory(
                new PropertyValueFactory<>("brand"));

        customer_col_model.setCellValueFactory(
                new PropertyValueFactory<>("model"));

        customer_col_total.setCellValueFactory(
                new PropertyValueFactory<>("total"));

        customer_tableView.setItems(customerList);
    }
    
    public void customerSearch() {

        FilteredList<customerData> filter =
                new FilteredList<>(customerList, e -> true);

        customer_search.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicateCustomer -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCustomer.getCustomerId().toString().contains(searchKey)) {
                    return true;

                } else if (predicateCustomer.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;

                } else if (predicateCustomer.getLastName().toLowerCase().contains(searchKey)) {
                    return true;

                } else if (predicateCustomer.getBrand().toLowerCase().contains(searchKey)) {
                    return true;

                } else if (predicateCustomer.getModel().toLowerCase().contains(searchKey)) {
                    return true;

                } else {
                    return false;
                }

            });

        });

        SortedList<customerData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(
                customer_tableView.comparatorProperty());

        customer_tableView.setItems(sortList);
    }
    
    public void rentPay(){
        rentCustomerId();
        
        String sql = "INSERT INTO customer "
                + "(customer_id, firstName, lastName, gender, car_id, brand"
                + ", model, total, date_rented, date_return) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        connect = database.connectDb();
        
        try{
            Alert alert;
            
            if(rent_firstName.getText().isEmpty()
                    || rent_lastName.getText().isEmpty()
                    || rent_gender.getSelectionModel().getSelectedItem() == null
                    || rent_carId.getSelectionModel().getSelectedItem() == null
                    || rent_brand.getSelectionModel().getSelectedItem() == null
                    || rent_model.getSelectionModel().getSelectedItem() == null
                    || totalP == 0 || rent_amount.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Something wrong :3");
                alert.showAndWait();
            }else{
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(customerId));
                    prepare.setString(2, rent_firstName.getText());
                    prepare.setString(3, rent_lastName.getText());
                    prepare.setString(4, (String)rent_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(5, (String)rent_carId.getSelectionModel().getSelectedItem());
                    prepare.setString(6, (String)rent_brand.getSelectionModel().getSelectedItem());
                    prepare.setString(7, (String)rent_model.getSelectionModel().getSelectedItem());
                    prepare.setString(8, String.valueOf(totalP));
                    prepare.setString(9, String.valueOf(rent_dateRented.getValue()));
                    prepare.setString(10, String.valueOf(rent_dateReturn.getValue()));

                    prepare.executeUpdate();
                    
                    String invoiceSql = "INSERT INTO invoice "
                            + "(customer_id, first_name, last_name, car_id, brand, model, "
                            + "date_rented, date_return, total, amount, balance, date_invoice) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(invoiceSql);

                    prepare.setInt(1, customerId);

                    prepare.setString(2, rent_firstName.getText());

                    prepare.setString(3, rent_lastName.getText());

                    prepare.setInt(4,
                            Integer.parseInt(
                                    rent_carId.getSelectionModel().getSelectedItem().toString()
                            ));

                    prepare.setString(5,
                            rent_brand.getSelectionModel().getSelectedItem().toString());

                    prepare.setString(6,
                            rent_model.getSelectionModel().getSelectedItem().toString());

                    prepare.setDate(7,
                            java.sql.Date.valueOf(rent_dateRented.getValue()));

                    prepare.setDate(8,
                            java.sql.Date.valueOf(rent_dateReturn.getValue()));

                    prepare.setDouble(9, totalP);

                    prepare.setDouble(10, amount);

                    prepare.setDouble(11, balance);

                    prepare.setDate(12,
                            new java.sql.Date(System.currentTimeMillis()));

                    prepare.executeUpdate();
                    System.out.println("INVOICE BERHASIL DISIMPAN");
                    
                    // SET THE  STATUS OF CAR TO NOT AVAILABLE 
                    String updateCar = "UPDATE car SET status = 'Not Available' WHERE car_id = '"
                            +rent_carId.getSelectionModel().getSelectedItem()+"'";
                    
                    statement = connect.createStatement();
                    statement.executeUpdate(updateCar);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Successful!");
                    alert.showAndWait();
                    
                    rentCarShowListData();
                    invoiceShowListData();
                    
                    rentClear();
                } // NOW LETS PROCEED TO DASHBOARD FORM : ) 
            }
        }catch(Exception e){
            System.out.println("ERROR INVOICE:");
            e.printStackTrace();
        }
        
    }
    
    public void rentClear(){
        totalP = 0;
        rent_firstName.setText("");
        rent_lastName.setText("");
        rent_gender.getSelectionModel().clearSelection();
        amount = 0;
        balance = 0;
        rent_balance.setText("Rp 0");
        rent_total.setText("Rp 0");
        rent_amount.setText("");
        rent_carId.getSelectionModel().clearSelection();
        rent_brand.getSelectionModel().clearSelection();
        rent_model.getSelectionModel().clearSelection();
    }
    
    private int customerId;
    public void rentCustomerId(){
        String sql = "SELECT id FROM customer";
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                // GET THE LAST id and add + 1
                customerId = result.getInt("id") + 1;
            }
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    private double amount;
    private double balance;
    public void rentAmount(){
        Alert alert;
        if(totalP == 0 || rent_amount.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid :3");
            alert.showAndWait();
            
            rent_amount.setText("");
        }else{
            amount = Double.parseDouble(rent_amount.getText());
            
            if(amount >= totalP){
                balance = (amount - totalP);
//                rent_balance.setText("Rp " + String.valueOf(balance));
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                rent_balance.setText(formatRupiah.format(balance));
            }else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid :3");
                alert.showAndWait();
                
                rent_amount.setText("");
            }
            
        }
        
    }

    public ObservableList<carData> rentCarListData() {

        ObservableList<carData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM car";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            carData carD;

            while (result.next()) {
                carD = new carData(result.getInt("car_id"), result.getString("brand"),
                         result.getString("model"), result.getDouble("price"),
                         result.getString("status"),
                         result.getString("image"),
                         result.getDate("date"),
                         result.getString("plate_number"));

                listData.add(carD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    private int countDate;
    public void rentDate(){
        Alert alert;
        if(rent_carId.getSelectionModel().getSelectedItem() == null
                || rent_brand.getSelectionModel().getSelectedItem() == null
                || rent_model.getSelectionModel().getSelectedItem() == null){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Something wrong :3");
            alert.showAndWait();
            
            rent_dateRented.setValue(null);
            rent_dateReturn.setValue(null);
            
        }else{
            
            if(rent_dateReturn.getValue().isAfter(rent_dateRented.getValue())){
                // COUNT THE DAY
                countDate = rent_dateReturn.getValue().compareTo(rent_dateRented.getValue());
            }else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something wrong :3");
                alert.showAndWait();
                // INCREASE OF 1 DAY ONCE THE USER CLICKED THE SAME DAY 
                rent_dateReturn.setValue(rent_dateRented.getValue().plusDays(1));
                
            }
        }
    }
    
    private double totalP;
    public void rentDisplayTotal(){
        rentDate();
        double price = 0;
        String sql = "SELECT price, model FROM car WHERE model = '"
                +rent_model.getSelectionModel().getSelectedItem()+"'";
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()){
                price = result.getDouble("price");
            }
            // price * the count day you want to use the car
            totalP = (price * countDate);
            // DISPLAY TOTAL
//            rent_total.setText("Rp " + String.valueOf(totalP));
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            rent_total.setText(formatRupiah.format(totalP));
            
        }catch(Exception e){e.printStackTrace();}
        
    }

    private String[] genderList = {"Male", "Female"};

    public void rentCarGender() {

        List<String> listG = new ArrayList<>();

        for (String data : genderList) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);

        rent_gender.setItems(listData);

    }

    public void rentCarCarId() {

        String sql = "SELECT * FROM car WHERE status = 'Available'";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("car_id"));
            }

            rent_carId.setItems(listData);

            rentCarBrand();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   public void rentCarBrand() { 
       String sql = "SELECT * FROM car WHERE car_id = '" + rent_carId.getSelectionModel().getSelectedItem() + "'"; 
       connect = database.connectDb(); 
       try { 
            prepare = connect.prepareStatement(sql); 
            result = prepare.executeQuery(); 
            
            ObservableList listData = FXCollections.observableArrayList(); 
            while (result.next()) { 
               listData.add(result.getString("brand")); 
            } 
            rent_brand.setItems(listData); rentCarModel(); 
       } catch (Exception e) { 
           e.printStackTrace(); 
       } 
   }

    public void rentCarModel() { 
        String sql = "SELECT * FROM car WHERE brand = '" + rent_brand.getSelectionModel().getSelectedItem() + "'"; 
        connect = database.connectDb(); 
        try { 
            prepare = connect.prepareStatement(sql); 
            result = prepare.executeQuery(); 
            
            ObservableList listData = FXCollections.observableArrayList(); 
            while (result.next()) { 
                listData.add(result.getString("model")); 
            } 
            rent_model.setItems(listData); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
    
    private ObservableList<carData> rentCarList;
    public void rentCarShowListData() {
        rentCarList = rentCarListData();

        rent_col_carId.setCellValueFactory(new PropertyValueFactory<>("carId"));
        rent_col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        rent_col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        rent_col_plateNumber.setCellValueFactory(new PropertyValueFactory<>("plateNumber"));

        rent_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        rent_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        rent_tableView.setItems(rentCarList);
    }
    
    public ObservableList<invoiceData> invoiceListData() {

        ObservableList<invoiceData> listData
                = FXCollections.observableArrayList();

        String sql = "SELECT * FROM invoice";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            invoiceData invData;

            while(result.next()) {

                String customerName
                        = result.getString("first_name")
                        + " "
                        + result.getString("last_name");

                String carName
                        = result.getString("brand")
                        + " "
                        + result.getString("model");

                invData = new invoiceData(

                        result.getInt("invoice_id"),
//                        result.getInt("customer_id"),
                        customerName,
                        carName,
                        result.getDouble("total"),
                        result.getDouble("amount"),
                        result.getDouble("balance"),
                        result.getDate("date_invoice")

                );

                listData.add(invData);

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return listData;

    }
    
    private ObservableList<invoiceData> invoiceList;
    public void invoiceShowListData() {

        invoiceList = invoiceListData();

        invoice_col_invoiceId.setCellValueFactory(
                new PropertyValueFactory<>("invoiceId"));

        invoice_col_customer.setCellValueFactory(
                new PropertyValueFactory<>("customer"));

        invoice_col_car.setCellValueFactory(
                new PropertyValueFactory<>("car"));

        invoice_col_total.setCellValueFactory(
                new PropertyValueFactory<>("total"));

        invoice_col_amount.setCellValueFactory(
                new PropertyValueFactory<>("amount"));

        invoice_col_balance.setCellValueFactory(
                new PropertyValueFactory<>("balance"));

        invoice_col_date.setCellValueFactory(
                new PropertyValueFactory<>("date"));

        invoice_tableView.setItems(invoiceList);

    }
    
    public void addButtonToInvoiceTable() {

        Callback<TableColumn<invoiceData, String>, TableCell<invoiceData, String>> cellFactory
                = (TableColumn<invoiceData, String> param) -> {

            final TableCell<invoiceData, String> cell = new TableCell<invoiceData, String>() {

                private final Button btn = new Button("Print");

                {
                    btn.setOnAction((event) -> {

                        invoiceData data = getTableView().getItems().get(getIndex());

                        try {

                            Connection connect = database.connectDb();

                            InputStream reportStream = getClass().getResourceAsStream(
                                    "/carrentalmanagementsystem/report/invoiceSingleReport.jasper");

                            HashMap<String, Object> map = new HashMap<>();

                            map.put("invoiceId", data.getInvoiceId());

                            JasperPrint jp = JasperFillManager.fillReport(
                                    reportStream,
                                    map,
                                    connect
                            );

                            JasperViewer.viewReport(jp, false);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    });

                    btn.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
                }

                @Override
                protected void updateItem(String item, boolean empty) {

                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        setGraphic(btn);
                        setText(null);
                    }
                }

            };

            return cell;
        };

        invoice_col_action.setCellFactory(cellFactory);

    }
    
    @FXML
    public void printCustomerReport() {

        try {

            Connection connect = database.connectDb();

            JasperReport jr = (JasperReport) JRLoader.loadObject(
                getClass().getResource("/carrentalmanagementsystem/report/customerReport.jasper")
            );

            JasperPrint jp = JasperFillManager.fillReport(
                jr,
                new HashMap<>(),
                connect
            );

            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayUsername() {
        String user = getData.username;
        // TO SET THE FIRST LETTER TO BIG LETTER
        username.setText(user.substring(0, 1).toUpperCase() + user.substring(1));

    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {
                // HIDE YOUR DASHBOARD FORM
                logoutBtn.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            availableCars_form.setVisible(false);
            customerCars_form.setVisible(false);
            rent_form.setVisible(false);
            invoice_form.setVisible(false);

            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #686f86, #8e9296);");
            availableCars_btn.setStyle("-fx-background-color:transparent");
            customerCars_btn.setStyle("-fx-background-color:transparent");
            rentCar_btn.setStyle("-fx-background-color:transparent");
            invoice_btn.setStyle("-fx-background-color:transparent");

            homeAvailableCars();
            homeTotalIncome();
            homeTotalCustomers();
            homeIncomeChart();
            homeCustomerChart();
            
        } else if (event.getSource() == availableCars_btn) {
            home_form.setVisible(false);
            availableCars_form.setVisible(true);
            customerCars_form.setVisible(false);
            rent_form.setVisible(false);
            invoice_form.setVisible(false);

            availableCars_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #686f86, #8e9296);");
            home_btn.setStyle("-fx-background-color:transparent");
            customerCars_btn.setStyle("-fx-background-color:transparent");
            rentCar_btn.setStyle("-fx-background-color:transparent");
            invoice_btn.setStyle("-fx-background-color:transparent");

            // TO UPDATE YOUR TABLEVIEW ONCE YOU CLICK THE AVAILABLE CAR NAV BUTTON
            availableCarShowListData();
            availableCarStatusList();
            availableCarSearch();

        } else if (event.getSource() == customerCars_btn) {
            home_form.setVisible(false);
            availableCars_form.setVisible(false);
            customerCars_form.setVisible(true);
            rent_form.setVisible(false);
            invoice_form.setVisible(false);
            
            customerCars_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #686f86, #8e9296);");
            home_btn.setStyle("-fx-background-color:transparent");
            availableCars_btn.setStyle("-fx-background-color:transparent");
            rentCar_btn.setStyle("-fx-background-color:transparent");
            invoice_btn.setStyle("-fx-background-color:transparent");
            
            customerShowListData();
            customerSearch();
        
        
        } else if (event.getSource() == rentCar_btn) {
            home_form.setVisible(false);
            availableCars_form.setVisible(false);
            customerCars_form.setVisible(false);
            rent_form.setVisible(true);
            invoice_form.setVisible(false);

            rentCar_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #686f86, #8e9296);");
            home_btn.setStyle("-fx-background-color:transparent");
            availableCars_btn.setStyle("-fx-background-color:transparent");
            customerCars_btn.setStyle("-fx-background-color:transparent");
            invoice_btn.setStyle("-fx-background-color:transparent");

            rentCarShowListData();
            rentCarCarId();
            rentCarBrand();
            rentCarModel();
            rentCarGender();

        } else if(event.getSource() == invoice_btn){

            home_form.setVisible(false);
            availableCars_form.setVisible(false);
            customerCars_form.setVisible(false);
            rent_form.setVisible(false);
            invoice_form.setVisible(true);
                    
            home_btn.setStyle("-fx-background-color:transparent");
            availableCars_btn.setStyle("-fx-background-color:transparent");
            customerCars_btn.setStyle("-fx-background-color:transparent");
            rentCar_btn.setStyle("-fx-background-color:transparent");            
            invoice_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #686f86, #8e9296);");

            invoiceShowListData();

        }

    }
    
    public void exportInvoiceReport(ActionEvent event) {

        try {

            Connection connect = database.connectDb();

            InputStream reportStream = getClass().getResourceAsStream("/carrentalmanagementsystem/report/invoiceReport.jasper");

            JasperPrint jp = JasperFillManager.fillReport(reportStream, null, connect);

            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();

        homeAvailableCars();
        homeTotalIncome();
        homeTotalCustomers();
        homeIncomeChart();
        homeCustomerChart();
        
        
        // TO DISPLAY THE DATA ON THE TABLEVIEW
        availableCarShowListData();
        availableCarStatusList();
        availableCarSearch();

        rentCarShowListData();
        rentCarCarId();
        rentCarBrand();
        rentCarModel();
        rentCarGender();
        
        customerShowListData();
        customerSearch();
        
        invoiceShowListData();
        addButtonToInvoiceTable();

    }

}
