package com.devonfw.application.jtqj.accesscodemanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.jtqj.accesscodemanagement.logic.api.Accesscodemanagement;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.EstimatedTime;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.NextCodeCto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.RemainingCodes;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.Uuid;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase.UcFindAccessCode;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase.UcManageAccessCode;
import com.devonfw.application.jtqj.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of accesscodemanagement
 */
@Named
public class AccesscodemanagementImpl extends AbstractComponentFacade implements Accesscodemanagement {

	@Inject
	private UcFindAccessCode ucFindAccessCode;

	@Inject
	private UcManageAccessCode ucManageAccessCode;

	@Override
	public AccessCodeCto findAccessCodeCto(long id) {

		return ucFindAccessCode.findAccessCodeCto(id);
	}

	@Override
	public Page<AccessCodeCto> findAccessCodeCtos(AccessCodeSearchCriteriaTo criteria) {

		return ucFindAccessCode.findAccessCodeCtos(criteria);
	}

	@Override
	public AccessCodeCto findUuidAccessCode(Uuid uuid) {
		return ucFindAccessCode.findUuidAccessCode(uuid);
	}

	@Override
	public AccessCodeEto saveAccessCode(AccessCodeEto accesscode) {

		return this.ucManageAccessCode.saveAccessCode(accesscode);
	}

	@Override
	public boolean deleteAccessCode(long id) {

		return this.ucManageAccessCode.deleteAccessCode(id);
	}

	@Override
	public AccessCodeEto findAccessCode(long id) {

		return this.ucFindAccessCode.findAccessCode(id);
	}

	@Override
	public Page<AccessCodeEto> findAccessCodes(AccessCodeSearchCriteriaTo criteria) {
		return this.ucFindAccessCode.findAccessCodes(criteria);
	}

	@Override
	public List<AccessCodeEto> findByQueue(long queueId) {
		return this.ucFindAccessCode.findByQueue(queueId);
	}

	@Override
	public void updateCodesOnStartQueue(long queueId) {
		this.ucManageAccessCode.updateCodesOnStartQueue(queueId);
	}

	@Override
	public NextCodeCto callNextCode() {
		return this.ucManageAccessCode.callNextCode();
	}

	@Override
	public AccessCodeEto findCurrentCode() {
		return this.ucFindAccessCode.findCurrentCode();
	}

	@Override
	public NextCodeCto findNextCode(long queueId) {
		return this.ucFindAccessCode.findNextCode(queueId);
	}

	@Override
	public EstimatedTime calculateEstimatedTime(AccessCodeEto code) {
		return this.ucManageAccessCode.calculateEstimatedTime(code);
	}

	@Override
	public RemainingCodes findRemainingCodes() {
		return this.ucFindAccessCode.findRemainingCodes();
	}
}
