export class GearbestApi {
  id: string;
  name: string;
}

export interface ListCouponResponse {
  error_no?: number;
  msg?: string;
  request?: string;
  data?: ListCouponResponseData;
}

export interface ListCouponResponseData {
  total_results?: number;
  total_pages?: number;
  page_no?: number;
  items?: Array<ListCoupon>;
}

export interface ListCoupon {
  description?: string;
  coupon_name?: string;
  coupon_code?: string;
  image_url?: string;
  start_date?: string;
  end_date?: string;
  coupon_url?: string;
  language?: string;
  sale_price?: string;
  coupon_type?: string;
  discounted_price?: string;
  discount_percent?: string;
  coupon_limits?: number;
  coupon_used?: number;
  coupon_unused?: number;
  category?: string;
  promotion_url?: string;
}


