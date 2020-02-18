package com.portal.business.commons.data;

import com.portal.business.commons.exceptions.EmptyListException;
import com.portal.business.commons.exceptions.GeneralException;
import com.portal.business.commons.exceptions.NullParameterException;
import com.portal.business.commons.exceptions.RegisterNotFoundException;
import com.portal.business.commons.generic.AbstractBusinessPortalWs;
import com.portal.business.commons.generic.WsRequest;
import com.portal.business.commons.models.Commerce;
import com.portal.business.commons.models.PreferenceField;
import com.portal.business.commons.models.Store;
import com.portal.business.commons.models.StoreBalance;
import com.portal.business.commons.models.StoreSetting;
import com.portal.business.commons.utils.EjbConstants;
import com.portal.business.commons.utils.QueryConstants;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author usuario
 */
public class StoreData extends AbstractBusinessPortalWs {

    private static final Logger logger = Logger.getLogger(StoreData.class);

    public List<Store> getStores(Commerce commerce) throws EmptyListException, GeneralException, NullParameterException {
        List<Store> stores = null;
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Store> cq = cb.createQuery(Store.class);
            Root<Store> from = cq.from(Store.class);
            cq.select(from).where(cb.equal(from.get("commerce"), commerce));

            Query query = entityManager.createQuery(cq);
            stores = query.getResultList();
        } catch (Exception e) {
            throw new GeneralException(logger, sysError.format(EjbConstants.ERR_GENERAL_EXCEPTION, this.getClass(), getMethodName(), e.getMessage()), null);
        }
        if (stores == null || stores.isEmpty()) {
            throw new EmptyListException(logger, sysError.format(EjbConstants.ERR_EMPTY_LIST_EXCEPTION, this.getClass(), getMethodName()), null);
        }
        return stores;

    }

    public Store loadStore(WsRequest request) throws GeneralException, RegisterNotFoundException, NullParameterException {
        return (Store) loadEntity(Store.class, request, logger, getMethodName());
    }

    public Store saveStore(Store store) throws NullParameterException, GeneralException {
        if (store == null) {
            throw new NullParameterException(sysError.format(EjbConstants.ERR_NULL_PARAMETER, this.getClass(), getMethodName(), "store"), null);
        }
        return (Store) saveEntity(store);
    }
}