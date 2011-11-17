function jStartExcel() {
var xls = new ActiveXObject ( "Excel.Application" );
xls.visible = true;
var newBook = xls.Workbooks.Add;
newBook.Worksheets.Add;
newBook.Worksheets(1).Activate;
xls.ActiveWorkBook.ActiveSheet.PageSetup.Orientation = 2;
xls.ActiveWorkBook.ActiveSheet.PageSetup.PaperSize = 5;
newBook.Worksheets(1).Columns("A").columnwidth=50;
newBook.Worksheets(1).Columns("A").WrapText = true;
newBook.Worksheets(1).Columns("B").columnwidth=50;
newBook.Worksheets(1).Columns("B").WrapText = true;
newBook.Worksheets(1).Range("A1:B1000").NumberFormat = "0";
newBook.Worksheets(1).Range("A1:B1000").HorizontalAlignment = -4131;
newBook.Worksheets(1).Cells(1,1).Interior.ColorIndex="15";
newBook.Worksheets(1).Cells(1,1).value="First Column, First Cell";
newBook.Worksheets(1).Cells(2,1).value="First Column, Second Cell";
newBook.Worksheets(1).Cells(1,2).value="Second Column, First Cell";
newBook.Worksheets(1).Cells(2,2).value="Second Column, Second Cell";
newBook.Worksheets(1).Name="My First WorkSheet";
}
