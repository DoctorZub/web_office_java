package Contrillers;

import Entities.Equipment;
import Contrillers.util.JsfUtil;
import Contrillers.util.PaginationHelper;
import Facde.EquipmentFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("equipmentController")
@RequestScoped
public class EquipmentController implements Serializable {

    private Equipment current;
    private DataModel items = null;
    @EJB
    private Facde.EquipmentFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public EquipmentController() {
    }

    public Equipment getSelected() {
        if (current == null) {
            current = new Equipment();
            selectedItemIndex = -1;
        }
        return current;
    }

    public EquipmentFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

              @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangenew(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                
                @Override
                public DataModel createPageDataModelEVS() {
                    return new ListDataModel(getFacade().findRangeEVS(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                @Override
                public DataModel createPageDataModelGKS() {
                    return new ListDataModel(getFacade().findRangeGKS(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                @Override
                public DataModel createPageDataModelLES() {
                    return new ListDataModel(getFacade().findRangeLES(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }
    
    public PaginationHelper getPaginationEVS() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().countEVS();
                }

               @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                
                @Override
                public DataModel createPageDataModelEVS() {
                    return new ListDataModel(getFacade().findRangeEVS(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                @Override
                public DataModel createPageDataModelGKS() {
                    return new ListDataModel(getFacade().findRangeGKS(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                @Override
                public DataModel createPageDataModelLES() {
                    return new ListDataModel(getFacade().findRangeLES(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }
    public PaginationHelper getPaginationGKS() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().countGKS();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                
                @Override
                public DataModel createPageDataModelEVS() {
                    return new ListDataModel(getFacade().findRangeEVS(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                @Override
                public DataModel createPageDataModelGKS() {
                    return new ListDataModel(getFacade().findRangeGKS(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                @Override
                public DataModel createPageDataModelLES() {
                    return new ListDataModel(getFacade().findRangeLES(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                
            };
        }
        return pagination;
    }
        public PaginationHelper getPaginationLES() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().countLES();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                
                @Override
                public DataModel createPageDataModelEVS() {
                    return new ListDataModel(getFacade().findRangeEVS(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                @Override
                public DataModel createPageDataModelGKS() {
                    return new ListDataModel(getFacade().findRangeGKS(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                @Override
                public DataModel createPageDataModelLES() {
                    return new ListDataModel(getFacade().findRangeLES(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
                
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Equipment) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }
    public String prepareViewEVS() {
        current = (Equipment) getItemsEVS().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItemsEVS().getRowIndex();
        return "/equipment/ViewDep";
    }
    public String prepareViewGKS() {
        current = (Equipment) getItemsGKS().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItemsGKS().getRowIndex();
        return "/equipment/ViewDep";
    }
    public String prepareViewLES() {
        current = (Equipment) getItemsLES().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItemsLES().getRowIndex();
        return "/equipment/ViewDep";
    }
   

    public String prepareCreate() {
        current = new Equipment();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EquipmentCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Equipment) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EquipmentUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    

    public String destroy() {
        current = (Equipment) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EquipmentDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }
    
    public DataModel getItemsEVS() {
        if (items == null) {
            items = getPaginationEVS().createPageDataModelEVS();
        }
        return items;
    }
    public DataModel getItemsGKS() {
        if (items == null) {
            items = getPaginationGKS().createPageDataModelGKS();
        }
        return items;
    }
    public DataModel getItemsLES() {
        if (items == null) {
            items = getPaginationLES().createPageDataModelLES();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Equipment getEquipment(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    public List<Equipment> ggetEquipment() {
        return ejbFacade.findAlltest();
    }

    public List<Equipment> gL(){
        return ejbFacade.getApp();
    }
    
    public List<Equipment> gL2(){
        return ejbFacade.getApp2();
    }
    
    public List<Equipment> searchCh(String a){
        return ejbFacade.search(a);
    }
    
    public List<Equipment> searchDEP(String a){
        return ejbFacade.searchDEP(a);
    }
    
    public Number sumPrice() {
        return ejbFacade.sumPrice();
    }
    public Number sumPriceEVS() {
        return ejbFacade.sumPriceEVS();
    }
    public Number sumPriceGKS() {
        return ejbFacade.sumPriceGKS();
    }
    public Number sumPriceLES() {
        return ejbFacade.sumPriceLES();
    }

    @FacesConverter(forClass = Equipment.class)
    public static class EquipmentControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EquipmentController controller = (EquipmentController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "equipmentController");
            return controller.getEquipment(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Equipment) {
                Equipment o = (Equipment) object;
                return getStringKey(o.getEquipmentId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Equipment.class.getName());
            }
        }

    }
    

}
