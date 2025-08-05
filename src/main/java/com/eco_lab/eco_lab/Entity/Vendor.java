package com.eco_lab.eco_lab.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Vendor")
public class Vendor {

    // Requestor Details
    @NonNull
    private String name;

    @NonNull
    private String requestorPhone;

    @NonNull
    @Indexed(unique = true)
    private String requestorEmail;

    private String indicateAction;
    private String typeOfAccount;

    @NonNull
    @Indexed(unique = true)
    private String vendorNumber;

    private String directOrIndirectVendor;
    private String functionalArea;
    private String dropshipmentVendor;

    @NonNull
    private BigDecimal estimatedAnnualSpend;

    private Boolean twoOffersAvailable;
    private String exceptionDescription;

    @NonNull
    private String companyCode;

    @NonNull
    private String purchasingOrganisation;

    private String team;
    private String category;
    private String subcategory;

    private String procurementApprover;
    private String procurementApproverBackup;
    private String financeApprover;

    // Vendor Information
    @NonNull
    private String vendorNameLocal;

    private String vendorNameEN;
    private String searchTerm;
    private String street1;
    private String street2;
    private String postalCode;
    private String poBox;
    private String poBoxPostalCode;
    private String townCity;
    private String country;
    private String taxBranchCode;
    private String stateRegionProvince;
    private String emailPO;
    private String communicationLanguage;
    private String emailRemittance;
    private String transportationZone;
    private String telephone;
    private String telephoneExt;
    private String fax;
    private String taxRegistrationNumber;

    @NonNull
    @Indexed(unique = true)
    private String companyTaxID;

    private String bankCountry;
    private String bankKey;
    private String bankControlKey;
    private String bankAccount;
    private String iban;
    private String swiftBic;
    private String partnerBankType;
    private String bankName;
    private String bankStreet;
    private String bankCity;
    private String instructionKey;

    // Contact Person
    private String firstName;
    private String lastName;
    private String contactTelephone;
    private String department;
    private String function;

    // Finance & Compliance
    private String financeCompanyCode;
    private String paymentTerms;
    private String paymentMethod;
    private String alternativePayee;
    private String deliveryInfo;
    private String withholdingCountryCode;
    private String wtType;
    private String wtCode;
    private String wtFormPercentage;
    private String purchOrg;
    private String orderCurrency;
    private String incoterms1;
    private String incoterms2;

    // Miscellaneous
    private String additionalInformation;
    private String documentFlow;
    private String support;

}
