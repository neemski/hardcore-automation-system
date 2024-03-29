package com.hardcoresoft.has.datastorage;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Function: public class LightingSchedule
 * Description: Container class for storing lighting schedule info. 
 */
public class LightingSchedule {
	
	//Global variables
	List<LightingScheduleNode> oSchedule;
	
	//Constructors
	
	public LightingSchedule(){
		oSchedule = new LinkedList<LightingScheduleNode>();
	}
	
	//Properties
	
	//Methods
	
	public List<LightingScheduleNode> getoSchedule() {
		return oSchedule;
	}

	/**
	 * Function: public Boolean addScheduledAction(LightingScheduleNode scheduleNode)
	 * Parameters: LightingScheduleNode scheduleNode - the Lighting schedule node to be added. 
	 * Description: Adds a new LightingScheduleNode, if it already contains that 
	 * date/time, false is returned.
	 */	
	public Boolean addScheduledAction(LightingScheduleNode scheduleNode){
		try
		{
			if(oSchedule.contains(scheduleNode))
			{
				return false;
			}
			return oSchedule.add(scheduleNode);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	//Do this if needed, don't think it is necessary at the moment. 
	public LightingScheduleNode getNextScheduledAction(Date currentDate){
		return null;
	}
	
	/**
	 * Function: public Boolean updateScheduledAction(Date date, Boolean status, int desiredBrightness, int desiredColourTemp)
	 * Parameters: Data date - date of the node to be updated. Boolean status - new light status. int desiredBrightness - new desired brightness.
	 * int desiredColourTemp - new desired colour temp. 
	 * Description: Removes the node with the provided date and subsequently replaces it with a new node
	 * with new brightness, status, and colour temp.
	 */
	public Boolean updateScheduledAction(Date date, Boolean status, int desiredBrightness, int desiredColourTemp){
		try{
			if(deleteScheduledAction(date) == true){
				LightingScheduleNode oNewNode = new LightingScheduleNode(date,status,desiredBrightness,desiredColourTemp); 
				return oSchedule.add(oNewNode);
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Function: public Boolean deleteScheduledAction(Date date)
	 * Parameters: Data date - date of the node to be removed.
	 * Description: Removes the node with the provided date.
	 */ 
	public Boolean deleteScheduledAction(Date date){
		try{
			LightingScheduleNode oCompare = new LightingScheduleNode(date,false,0,0);
			return oSchedule.remove(oCompare);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Function: public LightingScheduleNode findScheduledAction(Date date)
	 * Parameters: Data date - date of the node to be removed.
	 * Description: Finds the node with the provided date. Returns NULL if not found.
	 */
	public LightingScheduleNode findScheduledAction(Date date){
		try{
			LightingScheduleNode oCompare = new LightingScheduleNode(date,false,0,0);
			ListIterator<LightingScheduleNode> itr = oSchedule.listIterator();
			while(itr.hasNext()){
				LightingScheduleNode oItr = itr.next();
				if(oCompare.equals(oItr))
				{
					return oItr;
				}
			}
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	//toString for debugging.
	@Override public String toString() {
		try{
			StringBuilder result = new StringBuilder();
		    String NEW_LINE = System.getProperty("line.separator");
		    result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		    ListIterator<LightingScheduleNode> itr = oSchedule.listIterator();
		    while(itr.hasNext())
		    {
		    	result.append("<tns:action>" + NEW_LINE);
		    	result.append(itr.next());
		    	result.append("</tns:action>" + NEW_LINE);
		    }
		    return result.toString();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
