package fr.rouen.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;import fr.rouen.models.Entry;
import fr.rouen.models.ResumeEntries;
import fr.rouen.models.ResumeEntry;

public class DynamicModelResume extends AbstractTableModel {
	
	private List<ResumeEntry> resumeEntries;
	
	public List<ResumeEntry> getEntries() {
		return resumeEntries;
	}
	
    private final String[] columnNames = { "Titre",  "Date",  "Categorie(s)"};

    public DynamicModelResume(List<ResumeEntry> resumeEntries) {
    	super();
    	this.resumeEntries = resumeEntries;
    }
    
	@Override
	public int getRowCount() {
		return resumeEntries.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return resumeEntries.get(rowIndex).getTitle();
			case 1:
				return resumeEntries.get(rowIndex).getDate();
			case 2:
				if(resumeEntries.get(rowIndex).getCategories() != null) {
					String categoriesWithComma = String.join(" , ", resumeEntries.get(rowIndex).getCategories());
					return categoriesWithComma;
				}
				String NoCategory = "No category" ;
			default:
				return null;
		}
	}
	
	public void addEntry(ResumeEntry resumeEntry) {
		 resumeEntries.add(resumeEntry);
		 fireTableRowsInserted(resumeEntries.size() - 1, resumeEntries.size() - 1);
	 }
	 
    public void removeEntry(int rowIndex) {
    	resumeEntries.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    
    public ResumeEntry getEntryAtRow(int row) {
    	return this.resumeEntries.get(row);
    }
    
    public void clearModel() {
        int rows = resumeEntries.size();
        resumeEntries.clear();
        fireTableRowsDeleted(0, rows);
    }

}
