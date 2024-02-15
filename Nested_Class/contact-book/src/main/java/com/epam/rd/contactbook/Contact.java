package com.epam.rd.contactbook;

public class Contact {
	private String contactName;
	private int phoneNumber = 0;
	
	private final int MAX_EMAIL = 3;
	private int countEmail = 0;
	private ContactInfo[] emails;
	
	private final int MAX_SOCIAL = 5;
	private int countSocial = 0;
	private ContactInfo[] socials; 
	
	private ContactInfo[] phones;
	private ContactInfo[] infos;
	
	 public Contact(String contactName) {
	    this.contactName = contactName;
	    emails = new ContactInfo[MAX_EMAIL];
	    socials = new ContactInfo[MAX_SOCIAL];
	 }
	
	private class NameContactInfo implements ContactInfo{

		@Override
		public String getTitle() {
			return "Name";
		}

		@Override
		public String getValue() {
			return contactName;
		}
		
	}
	
	public static class Email implements ContactInfo{
		private String title;
		private String email;	
		
		public Email(String title, String email) {
			super();
			this.title = title;
			this.email = email;			
		}

		@Override
		public String getTitle() {
			return title;
		}

		@Override
		public String getValue() {
			return email;
		}
		
	} 
	
	public static class Social implements ContactInfo{
		private String link;
		private String value;
		
		public Social(String link, String value) {
			super();
			this.link = link;
			this.value = value;
		}

		@Override
		public String getTitle() {
			return link;
		}

		@Override
		public String getValue() {
			return value;
		}
		
	}	
   

    public void rename(String newName) {
        if(newName != null && !newName.isEmpty()) {
        	this.contactName = newName;
        }
    }

    public Email addEmail(String localPart, String domain) {    	
    	if(countEmail < MAX_EMAIL) {
    		Email email = new Email("Email", localPart+"@"+domain);
    		emails[countEmail++] = email;
    		return email;
    	}
		return null;
    }

    public Email addEpamEmail(String firstname, String lastname) {
    	if(countEmail < MAX_EMAIL) {
    		Email email = new Contact.Email(firstname, lastname) {
    			
    			@Override
    			public String getTitle() {    				
    				return "Epam Email";
    			}
    			
    			@Override
    			public String getValue() {  				
    				return firstname + "_" + lastname + "@" + "epam.com";
    			}   			
    		};
    		emails[countEmail++] = email;
    		return email;
    	}
		return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
    	if(phoneNumber < 1) {
    		ContactInfo contactInfo = new ContactInfo() {
				
				@Override
				public String getValue() {				
					return "+" + code + " " + number;
				}
				
				@Override
				public String getTitle() {				
					return "Tel";
				}
			};
			
			phones = new ContactInfo[1];
			phones[phoneNumber++] = contactInfo;    		
    		return contactInfo;
    	}
		return null;
    }

    public Social addTwitter(String twitterId) {
    	if(countSocial < MAX_SOCIAL) {
    		Social social = new Social("Twitter", twitterId);
    		
    		socials[countSocial++] = social;
    		return social;
    	}
		return null;
    }

    public Social addInstagram(String instagramId) {
    	if(countSocial < MAX_SOCIAL) {
    		Social social = new Social("Instagram", instagramId);
    		
    		socials[countSocial++] = social;
    		return social;
    	}
		return null;
    }

    public Social addSocialMedia(String title, String id) {
    	if(countSocial < MAX_SOCIAL) {
    		Social social = new Social(title, id);
    		
    		socials[countSocial++] = social;
    		return social;
    	}
		return null;
    }

    public ContactInfo[] getInfo() {
    	int index = 0;
    	infos = new ContactInfo[1 + countEmail + countSocial + phoneNumber];
    	infos[index++] = new NameContactInfo();
    	
    	if(phoneNumber > 0) {
    		infos[index++] = phones[0];
    	}
    	if(countEmail > 0) {
			for (ContactInfo emails : emails) {
    			if(emails != null) {
    				infos[index++] = emails;
    			}   			
    		}
		}
		
    	if(countSocial > 0) {
    		for (ContactInfo socials : socials) {
        		if(socials != null) {
        			infos[index++] = socials;
        		}  			
    		}
    	}
		return infos;
    }

}
