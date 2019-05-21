package br.com.rsinet.selenium_utils.enums;

/**
 * {@link Enum} que padroniza os formatos de data/hora.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public enum Formato {
	/**
	 * Formato de hora padrão (HH:mm:ss).
	 */
	HMS {
		@Override
		public String toString() {
			return "HH:mm:ss";
		}
	},
	/**
	 * Formato ano-mês (yyyy-MM).
	 */
	YEAR_MONTH {
		@Override
		public String toString() {
			return "yyyy-MM";
		}
	},
	MONTH_YEAR {
		@Override
		public String toString() {
			return "MM/yyyy";
		}
	},
	/**
	 * Formato dia (dd).
	 */
	DAY {
		@Override
		public String toString() {
			return "dd";
		}
	},
	/**
	 * Formato mês (MM).
	 */
	MONTH {
		@Override
		public String toString() {
			return "MM";
		}
	},
	/**
	 * Formato ano (yyyy).
	 */
	YEAR {
		@Override
		public String toString() {
			return "yyyy";
		}
	},
	/**
	 * Formato de data padrão (dd/MM/yyyy).
	 */
	DDMMYYYY {
		@Override
		public String toString() {
			return "dd/MM/yyyy";
		}
	},
	/**
	 * Formato de data inverso, separado por hífens (yyyy-MM-dd).
	 */
	YYYYMMDD {
		@Override
		public String toString() {
			return "yyyy-MM-dd";
		}
	},
	/**
	 * Formato de data inverso, separado por barras (yyyy/MM/dd).
	 */
	YMD {
		@Override
		public String toString() {
			return "yyyy/MM/dd";
		}
	},
	/**
	 * Formato de data/hora padrão ISO (dd/MM/yyyy HH:mm:ss).
	 */
	ISO_DATETIME {
		@Override
		public String toString() {
			return "dd/MM/yyyy HH:mm:ss";
		}
	};
}