/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cn.dlb.bim.models.ifc4.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import cn.dlb.bim.ifc.emf.IdEObjectImpl;
import cn.dlb.bim.models.ifc4.Ifc4Package;
import cn.dlb.bim.models.ifc4.IfcRecurrencePattern;
import cn.dlb.bim.models.ifc4.IfcRecurrenceTypeEnum;
import cn.dlb.bim.models.ifc4.IfcTimePeriod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Recurrence Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRecurrencePatternImpl#getRecurrenceType <em>Recurrence Type</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRecurrencePatternImpl#getDayComponent <em>Day Component</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRecurrencePatternImpl#getWeekdayComponent <em>Weekday Component</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRecurrencePatternImpl#getMonthComponent <em>Month Component</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRecurrencePatternImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRecurrencePatternImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRecurrencePatternImpl#getOccurrences <em>Occurrences</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRecurrencePatternImpl#getTimePeriods <em>Time Periods</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRecurrencePatternImpl extends IdEObjectImpl implements IfcRecurrencePattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRecurrencePatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_RECURRENCE_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRecurrenceTypeEnum getRecurrenceType() {
		return (IfcRecurrenceTypeEnum) eGet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__RECURRENCE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecurrenceType(IfcRecurrenceTypeEnum newRecurrenceType) {
		eSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__RECURRENCE_TYPE, newRecurrenceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Long> getDayComponent() {
		return (EList<Long>) eGet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__DAY_COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDayComponent() {
		eUnset(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__DAY_COMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDayComponent() {
		return eIsSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__DAY_COMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Long> getWeekdayComponent() {
		return (EList<Long>) eGet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__WEEKDAY_COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWeekdayComponent() {
		eUnset(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__WEEKDAY_COMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWeekdayComponent() {
		return eIsSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__WEEKDAY_COMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Long> getMonthComponent() {
		return (EList<Long>) eGet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__MONTH_COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMonthComponent() {
		eUnset(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__MONTH_COMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMonthComponent() {
		return eIsSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__MONTH_COMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPosition() {
		return (Long) eGet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(long newPosition) {
		eSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__POSITION, newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPosition() {
		eUnset(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__POSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPosition() {
		return eIsSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__POSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getInterval() {
		return (Long) eGet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__INTERVAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterval(long newInterval) {
		eSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__INTERVAL, newInterval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInterval() {
		eUnset(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__INTERVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInterval() {
		return eIsSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__INTERVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getOccurrences() {
		return (Long) eGet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__OCCURRENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccurrences(long newOccurrences) {
		eSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__OCCURRENCES, newOccurrences);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOccurrences() {
		eUnset(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__OCCURRENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOccurrences() {
		return eIsSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__OCCURRENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcTimePeriod> getTimePeriods() {
		return (EList<IfcTimePeriod>) eGet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__TIME_PERIODS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTimePeriods() {
		eUnset(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__TIME_PERIODS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTimePeriods() {
		return eIsSet(Ifc4Package.Literals.IFC_RECURRENCE_PATTERN__TIME_PERIODS);
	}

} //IfcRecurrencePatternImpl
